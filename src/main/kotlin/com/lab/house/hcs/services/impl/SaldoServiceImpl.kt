package com.lab.house.hcs.services.impl

import com.lab.house.core.Utils
import com.lab.house.hcs.entities.Month
import com.lab.house.hcs.entities.Saldo
import com.lab.house.hcs.repositories.ChargeRepository
import com.lab.house.hcs.repositories.PaymentRepository
import com.lab.house.hcs.repositories.SaldoRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.*

@Service
class SaldoServiceImpl {

    private val log = LoggerFactory.getLogger(SaldoServiceImpl::class.java)

    @Autowired
    lateinit var saldoRepository: SaldoRepository

    @Autowired
    lateinit var paymentRepository: PaymentRepository

    @Autowired
    lateinit var chargeRepository: ChargeRepository

    // CRON для тестирования "*/10 * * * * *"
    @Scheduled(cron = "0 0 9 25 * ?")
    fun calculationSaldoForAllCharges() {
        // Получаем текущий год и месяц для получения списка выставленных счетов
        val calendar = Calendar.getInstance()
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentYear = calendar.get(Calendar.YEAR)

        // Получаем все существующие выставленные счета из бд за текущий месяц
        val allChargesInCurrentMonthAndYear = chargeRepository.findAllByMonthAndYear(Month.fromInt(currentMonth), currentYear)

        // Пробегаемся по всем счетам в текущем месяце и году
        allChargesInCurrentMonthAndYear.forEach {
            // Получаем есть ли новое сальдо по выставленному счету. Если есть, то дальше не работаем с текущим выставленным счетом
            val currentSaldo = saldoRepository.findFirstByChargeAndMonthAndYear(it, Month.fromInt(currentMonth + 1), it.year)
            if (currentSaldo != null) return@forEach

            // Получаем все поступившие деньги на счет
            val valueAllPayments = paymentRepository.findAllByCharge(charge = it).sumByDouble { payment -> payment.value!! }

            // Получаем предыдущие даты для получения сальдо
            val previousDate = Utils.getPreviousDate(currentMonth, currentYear)
            val previousMonth = previousDate.first
            val previousYear = previousDate.second

            // Получаем сальдо за предыдущий месяц. Если вдруг уже начисляли, то приступаем к следующему
            val saldo = saldoRepository.findFirstByChargeAndMonthAndYear(it, previousMonth, previousYear)
            log.debug("Get saldo entity ${saldo?.id}")

            // Переменная для хранения суммы, которую необходимо оплатить с учетом сальдо
            val valueWithSaldo = if (saldo == null) {
                it.value
            } else {
                it.value.plus(saldo.value)
            }

            // Рассчитываем сальдо и добавляем в базу данных
            val saldoId = saldoRepository.save(Saldo().apply {
                value = valueWithSaldo.minus(valueAllPayments)
                year = currentYear
                month = Month.fromInt(currentMonth + 1)
                charge = it
            }).id ?: throw IllegalArgumentException("Bad saldo id returned.")

            log.debug("Updated saldo entity with ${saldoId}")
        }
    }

}

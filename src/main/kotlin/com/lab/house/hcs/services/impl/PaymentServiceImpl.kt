package com.lab.house.hcs.services.impl

import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.core.exceptions.PaymentException
import com.lab.house.hcs.entities.Month
import com.lab.house.hcs.entities.Payment
import com.lab.house.hcs.repositories.ChargeRepository
import com.lab.house.hcs.repositories.PaymentRepository
import com.lab.house.hcs.repositories.SaldoRepository
import com.lab.house.hcs.services.PaymentService
import com.lab.house.hcs.vo.payment.PaymentCreateRq
import com.lab.house.hcs.vo.payment.PaymentVO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class PaymentServiceImpl : PaymentService {

    private val log = LoggerFactory.getLogger(ChargeServiceImpl::class.java)

    @Autowired
    lateinit var paymentRepository: PaymentRepository

    @Autowired
    lateinit var chargeRepository: ChargeRepository

    @Autowired
    lateinit var saldoRepository: SaldoRepository

    @Throws(EntityNotFoundException::class)
    override fun getPaymentById(id: String): PaymentVO = paymentRepository.findById(id.toLong()).map(::toPaymentVO).orElseThrow { throw EntityNotFoundException("Payment with $id not found.") }

    @Throws(EntityNotFoundException::class)
    override fun getPayments(): List<PaymentVO> {
        return paymentRepository.findAll().map(::toPaymentVO)
    }

    @Throws(EntityNotFoundException::class, PaymentException::class)
    @Transactional
    override fun createPayment(chargeId: String, paymentCreateRq: PaymentCreateRq): PaymentVO {
        // Получаем выставленный счет. Если его нет, то выбрасываем исключение
        val charge = chargeRepository.findFirstByIdAndCompletePaymentIsFalse(chargeId.toLong())
                ?: throw PaymentException("Charge was paid.")

        // Получаем текущий год и месяц для проверки правильности оплаты. Эти поля должны сходится с полями выставленного счета
        val calendar = Calendar.getInstance()
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentYear = calendar.get(Calendar.YEAR)
        if (charge.year != currentYear || charge.month.ordinal != currentMonth)
            throw PaymentException("Date and Year not found.")

        // Проверяем не присылают ли нам отрицательную сумму
        if (paymentCreateRq.value != null && paymentCreateRq.value <= 0)
            throw PaymentException("The value is empty or less than 0.")

        // Оплата выставленного счета. Подсчет остального ниже
        val paymentId = paymentRepository.save(Payment().apply {
            value = paymentCreateRq.value
            year = calendar.get(Calendar.YEAR)
            month = Month.fromInt(currentMonth)
            this.charge = charge
        }).id ?: throw IllegalArgumentException("Bad payment id returned.")
        log.debug("Updated entity $paymentId")

        // Получаем предыдущие даты для получения сальдо
        val previousMonth = Month.fromInt(currentMonth - 1)
        val previousYear = if (previousMonth.ordinal != 0) {
            currentYear
        } else {
            currentYear - 1
        }

        // Получаем сальдо предыдущего месяца для использования в оплате
        val saldo = saldoRepository.findFirstByChargeAndMonthAndYear(charge, previousMonth, previousYear)
        log.debug("Get saldo entity ${saldo?.id}")

        // Переменная для хранения суммы, которую необходимо оплатить с учетом сальдо
        val valueWithSaldo = if (saldo == null) {
            charge.value
        } else {
            charge.value.plus(saldo.value)
        }

        // Обновляем поле completePayment выставленного счета, если оплата больше выставленного счета и сальдо
        if (paymentCreateRq.value!! >= valueWithSaldo) {
            val chargeId = chargeRepository.save(charge.apply {
                completePayment = true
            }).id ?: throw IllegalArgumentException("Bad charge id returned.")

            log.debug("Updated charge entity with $chargeId")
        }

        return getPaymentById(paymentId.toString())
    }

    private fun toPaymentVO(payment: Payment): PaymentVO {
        return PaymentVO.fromData(payment)
    }
}

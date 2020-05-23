package com.lab.house.hcs.services.impl

import com.lab.house.core.exceptions.AlreadyExistsException
import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.core.exceptions.PaymentException
import com.lab.house.hcs.entities.Charge
import com.lab.house.hcs.entities.House
import com.lab.house.hcs.repositories.ChargeRepository
import com.lab.house.hcs.repositories.HouseRepository
import com.lab.house.hcs.repositories.PaymentRepository
import com.lab.house.hcs.services.ChargeService
import com.lab.house.hcs.vo.charge.ChargeCreateRq
import com.lab.house.hcs.vo.charge.ChargeVO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ChargeServiceImpl : ChargeService {

    private val log = LoggerFactory.getLogger(ChargeServiceImpl::class.java)

    @Autowired
    lateinit var chargeRepository: ChargeRepository

    @Autowired
    lateinit var houseRepository: HouseRepository

    @Autowired
    lateinit var paymentRepository: PaymentRepository

    @Throws(EntityNotFoundException::class)
    override fun getChargeById(id: String): ChargeVO = chargeRepository.findById(id.toLong()).map(::toChargeVO).orElseThrow { throw EntityNotFoundException("Charge with $id not found.") }

    @Throws(EntityNotFoundException::class)
    override fun getCharges(): List<ChargeVO> {
        return chargeRepository.findAll().map(::toChargeVO)
    }

    @Throws(EntityNotFoundException::class, AlreadyExistsException::class)
    override fun createCharge(houseId: String, chargeCreateRq: ChargeCreateRq): ChargeVO {
        val house = houseRepository.findFirstByHouseNumber(houseId.toInt()) ?: throw EntityNotFoundException("House with $houseId not found.")
        if (chargeRepository.findFirstByHouseAndMonthAndYear(house, chargeCreateRq.month, chargeCreateRq.year) != null) throw AlreadyExistsException("Charge for this month already exist.")

        val id = chargeRepository.save(Charge().apply {
            month = chargeCreateRq.month
            year = chargeCreateRq.year
            value = chargeCreateRq.value
            this.house = house
        }).id ?: throw IllegalArgumentException("Bad id returned.")

        log.debug("Created entity $id")
        return getChargeById(id.toString())
    }

    @Throws(EntityNotFoundException::class, PaymentException::class, AlreadyExistsException::class)
    override fun updateCharge(id: String, chargeUpdateRq: ChargeCreateRq): ChargeVO {
        val charge = chargeRepository.findByIdOrNull(id.toLong()) ?: throw EntityNotFoundException("House with $id not found.")
        if (paymentRepository.findFirstByCharge(charge) != null) throw PaymentException("Charge was paid.")
        if (chargeRepository.findFirstByHouseAndMonthAndYear(charge.house!!, chargeUpdateRq.month, chargeUpdateRq.year) != null) throw AlreadyExistsException("Charge for this month already exist.")

        val id = chargeRepository.save(charge.apply {
            month = chargeUpdateRq.month
            year = chargeUpdateRq.year
            value = chargeUpdateRq.value
        }).id ?: throw IllegalArgumentException("Bad id returned.")

        log.debug("Updated entity $id")
        return getChargeById(id.toString())
    }

    @Throws(EntityNotFoundException::class, PaymentException::class)
    override fun delete(id: String) {
        val charge = chargeRepository.findByIdOrNull(id.toLong()) ?: throw EntityNotFoundException("House with $id not found.")
        if (paymentRepository.findFirstByCharge(charge) != null) throw PaymentException("Charge was paid.")

        chargeRepository.deleteById(id.toLong())
        log.debug("Deleted charge entity $id")
    }

    private fun toChargeVO(charge: Charge): ChargeVO {
        return ChargeVO.fromData(charge)
    }

}

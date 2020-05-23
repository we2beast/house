package com.lab.house.hcs.services

import com.lab.house.core.exceptions.AlreadyExistsException
import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.core.exceptions.PaymentException
import com.lab.house.hcs.vo.charge.ChargeCreateRq
import com.lab.house.hcs.vo.charge.ChargeVO

interface ChargeService {

    @Throws(EntityNotFoundException::class)
    fun getChargeById(id: String): ChargeVO

    @Throws(EntityNotFoundException::class)
    fun getCharges(): List<ChargeVO>

    @Throws(EntityNotFoundException::class, AlreadyExistsException::class)
    fun createCharge(houseId: String, chargeCreateRq: ChargeCreateRq): ChargeVO

    @Throws(EntityNotFoundException::class, PaymentException::class, AlreadyExistsException::class)
    fun updateCharge(id: String, chargeUpdateRq: ChargeCreateRq): ChargeVO

    @Throws(EntityNotFoundException::class, PaymentException::class)
    fun delete(id: String)

}

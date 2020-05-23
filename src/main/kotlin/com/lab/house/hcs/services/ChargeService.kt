package com.lab.house.hcs.services

import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.vo.hcs.HcsCreateRq
import com.lab.house.hcs.vo.hcs.HcsVO

interface ChargeService {

    @Throws(EntityNotFoundException::class)
    fun getChargeById(id: String): HcsVO

    @Throws(EntityNotFoundException::class)
    fun getCharges(): List<HcsVO>

    @Throws(EntityNotFoundException::class)
    fun createCharge(chargeCreateRq: HcsCreateRq): HcsVO

    @Throws(EntityNotFoundException::class)
    fun updateCharge(id: String, chargeUpdateRq: HcsCreateRq): HcsVO

    @Throws(EntityNotFoundException::class)
    fun delete(id: String)

}

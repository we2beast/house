package com.lab.house.hcs.services

import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.vo.hcs.HcsCreateRq
import com.lab.house.hcs.vo.hcs.HcsVO

interface Saldo {

    @Throws(EntityNotFoundException::class)
    fun getSaldoById(id: String): HcsVO

    @Throws(EntityNotFoundException::class)
    fun getSaldos(): List<HcsVO>

    @Throws(EntityNotFoundException::class)
    fun createSaldo(saldoCreateRq: HcsCreateRq): HcsVO

    @Throws(EntityNotFoundException::class)
    fun updateSaldo(id: String, saldoCreateRq: HcsCreateRq): HcsVO

    @Throws(EntityNotFoundException::class)
    fun delete(id: String)

}

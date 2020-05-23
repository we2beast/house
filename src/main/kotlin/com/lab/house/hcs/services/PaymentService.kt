package com.lab.house.hcs.services

import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.vo.hcs.HcsCreateRq
import com.lab.house.hcs.vo.hcs.HcsVO

interface PaymentService {

    @Throws(EntityNotFoundException::class)
    fun getPaymentById(id: String): HcsVO

    @Throws(EntityNotFoundException::class)
    fun getPayments(): List<HcsVO>

    @Throws(EntityNotFoundException::class)
    fun createPayment(paymentCreateRq: HcsCreateRq): HcsVO

    @Throws(EntityNotFoundException::class)
    fun updatePayment(id: String, paymentCreateRq: HcsCreateRq): HcsVO

    @Throws(EntityNotFoundException::class)
    fun delete(id: String)

}

package com.lab.house.hcs.services

import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.core.exceptions.PaymentException
import com.lab.house.hcs.vo.payment.PaymentCreateRq
import com.lab.house.hcs.vo.payment.PaymentVO

interface PaymentService {

    @Throws(EntityNotFoundException::class)
    fun getPaymentById(id: String): PaymentVO

    @Throws(EntityNotFoundException::class)
    fun getPayments(): List<PaymentVO>

    @Throws(EntityNotFoundException::class, PaymentException::class)
    fun createPayment(chargeId: String, paymentCreateRq: PaymentCreateRq): PaymentVO

}

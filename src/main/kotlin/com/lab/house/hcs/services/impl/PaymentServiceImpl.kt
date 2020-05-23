package com.lab.house.hcs.services.impl

import com.lab.house.hcs.services.PaymentService
import com.lab.house.hcs.vo.payment.PaymentCreateRq
import com.lab.house.hcs.vo.payment.PaymentVO
import org.springframework.stereotype.Service

@Service
class PaymentServiceImpl : PaymentService {
    override fun getPaymentById(id: String): PaymentVO {
        TODO("Not yet implemented")
    }

    override fun getPayments(): List<PaymentVO> {
        TODO("Not yet implemented")
    }

    override fun createPayment(chargeId: String, paymentCreateRq: PaymentCreateRq): PaymentVO {
        TODO("Not yet implemented")
    }

    override fun updatePayment(id: String, paymentCreateRq: PaymentCreateRq): PaymentVO {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}

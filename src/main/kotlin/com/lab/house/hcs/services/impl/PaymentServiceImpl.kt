package com.lab.house.hcs.services.impl

import com.lab.house.hcs.services.PaymentService
import com.lab.house.hcs.vo.hcs.HcsCreateRq
import com.lab.house.hcs.vo.hcs.HcsVO
import org.springframework.stereotype.Service

@Service
class PaymentServiceImpl : PaymentService {
    override fun getPaymentById(id: String): HcsVO {
        TODO("Not yet implemented")
    }

    override fun getPayments(): List<HcsVO> {
        TODO("Not yet implemented")
    }

    override fun createPayment(paymentCreateRq: HcsCreateRq): HcsVO {
        TODO("Not yet implemented")
    }

    override fun updatePayment(id: String, paymentCreateRq: HcsCreateRq): HcsVO {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}

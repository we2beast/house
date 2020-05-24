package com.lab.house.hcs.vo.payment

import com.lab.house.hcs.entities.*

data class PaymentVO(
        val id: Long? = null,
        val createdAt: String,
        val updatedAt: String,
        val value: Double? = 0.0,
        val year: Int? = 0,
        val month: Month? = Month.JANUARY
) {

    companion object {
        fun fromData(payment: Payment): PaymentVO =
                PaymentVO(
                        payment.id,
                        payment.createdAt.toString(),
                        payment.updatedAt.toString(),
                        payment.value,
                        payment.year,
                        payment.month
                )
    }

}

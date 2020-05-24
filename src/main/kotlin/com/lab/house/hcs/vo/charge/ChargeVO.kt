package com.lab.house.hcs.vo.charge

import com.lab.house.hcs.entities.*
import com.lab.house.hcs.vo.house.HouseVO
import com.lab.house.hcs.vo.payment.PaymentVO

data class ChargeVO(
        val id: Long? = null,
        val createdAt: String,
        val updatedAt: String,
        val value: Double? = 0.0,
        val year: Int? = 0,
        val month: Month = Month.JANUARY,
        val completePayment: Boolean = false,
        val house: HouseVO? = null,
        val payment: List<PaymentVO> = listOf(),
        val valueWithSaldo: Double? = null
) {

    companion object {
        fun fromData(charge: Charge): ChargeVO =
                ChargeVO(
                        charge.id,
                        charge.createdAt.toString(),
                        charge.updatedAt.toString(),
                        charge.value,
                        charge.year,
                        charge.month,
                        charge.completePayment,
                        charge.house?.let { HouseVO.fromData(it) },
                        charge.payment.map { PaymentVO.fromData(it) },
                        null
                )
    }

}

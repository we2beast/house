package com.lab.house.hcs.vo.charge

import com.lab.house.hcs.entities.*

data class ChargeVO(
        val id: Long? = null,
        val createdAt: String,
        val updatedAt: String,
        val value: Double? = 0.0,
        val year: Int? = 0,
        val month: Month = Month.JANUARY,
        val isPayment: Boolean = false,
        val house: MutableSet<House> = mutableSetOf(),
        val payment: MutableSet<Payment> = mutableSetOf(),
        val saldo: Saldo? = null
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
                        charge.isPayment,
                        charge.house,
                        charge.payment,
                        charge.saldo
                )
    }

}

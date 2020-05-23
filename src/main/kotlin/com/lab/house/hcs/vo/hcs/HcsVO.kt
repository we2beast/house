package com.lab.house.hcs.vo.hcs

import com.lab.house.hcs.entities.Charge
import com.lab.house.hcs.entities.Month

data class HcsVO(
        val id: Long? = null,
        val createdAt: String,
        val updatedAt: String,
        val value: Double? = 0.0,
        val year: Int? = 0,
        val month: Month = Month.JANUARY
) {

    companion object {
        fun fromData(charge: Charge): HcsVO =
                HcsVO(
                        charge.id,
                        charge.createdAt.toString(),
                        charge.updatedAt.toString(),
                        charge.value,
                        charge.year,
                        charge.month
                )
    }

}

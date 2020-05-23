package com.lab.house.hcs.vo.hcs

import com.lab.house.hcs.entities.Charge
import com.lab.house.hcs.entities.Month
import java.sql.Timestamp

data class HcsVO(
        val id: Long? = null,
        val createdAt: Timestamp = Timestamp(0),
        val updatedAt: Timestamp = Timestamp(0),
        val value: Double? = 0.0,
        val year: Int? = 0,
        val month: Month = Month.JANUARY
) {

    companion object {
        fun fromData(charge: Charge): HcsVO =
                HcsVO(
                        charge.id,
                        charge.createdAt,
                        charge.updatedAt,
                        charge.value,
                        charge.year,
                        charge.month
                )
    }

}

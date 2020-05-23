package com.lab.house.hcs.vo.house

import com.lab.house.hcs.entities.Contract
import com.lab.house.hcs.entities.House
import java.sql.Timestamp

data class HouseVO(
        val id: Long? = null,
        val createdAt: Timestamp = Timestamp(0),
        val updatedAt: Timestamp = Timestamp(0),
        val houseNumber: Int? = 0,
        val contract: Contract? = null
) {

    companion object {
        fun fromData(house: House): HouseVO =
                HouseVO(
                        house.id,
                        house.createdAt,
                        house.updatedAt,
                        house.houseNumber,
                        house.contract
                )
    }

}

package com.lab.house.hcs.vo.house

import com.lab.house.hcs.entities.Contract
import com.lab.house.hcs.entities.House
import java.sql.Timestamp

data class HouseVO(
        val id: Long? = null,
        val createdAt: String,
        val updatedAt: String,
        val houseNumber: Int? = 0,
        val contract: Contract? = null
) {

    companion object {
        fun fromData(house: House): HouseVO =
                HouseVO(
                        house.id,
                        house.createdAt.toString(),
                        house.updatedAt.toString(),
                        house.houseNumber,
                        house.contract
                )
    }

}

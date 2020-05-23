package com.lab.house.hcs.vo.house

import com.lab.house.hcs.entities.House
import com.lab.house.hcs.vo.contract.ContractVO

data class HouseVO(
        val id: Long? = null,
        val createdAt: String,
        val updatedAt: String,
        val houseNumber: Int? = 0,
        val contract: ContractVO? = null
) {

    companion object {
        fun fromData(house: House): HouseVO =
                HouseVO(
                        house.id,
                        house.createdAt.toString(),
                        house.updatedAt.toString(),
                        house.houseNumber,
                        house.contract?.let { ContractVO.fromData(it) }
                )
    }

}

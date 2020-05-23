package com.lab.house.hcs.vo.contract

import com.lab.house.hcs.entities.Contract
import com.lab.house.hcs.entities.House
import java.sql.Timestamp

data class ContractVO(
        val id: Long? = null,
        val createdAt: Timestamp = Timestamp(0),
        val updatedAt: Timestamp = Timestamp(0),
        val billNumber: Int? = 0,
        val house: House? = null
) {

    companion object {
        fun fromData(contract: Contract): ContractVO =
                ContractVO(
                        contract.id,
                        contract.createdAt,
                        contract.updatedAt,
                        contract.billNumber,
                        contract.house
                )
    }

}

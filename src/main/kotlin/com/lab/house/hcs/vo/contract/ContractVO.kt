package com.lab.house.hcs.vo.contract

import com.lab.house.hcs.entities.Contract

data class ContractVO(
        val id: Long? = null,
        val createdAt: String,
        val updatedAt: String,
        val billNumber: Int? = 0
) {

    companion object {
        fun fromData(contract: Contract): ContractVO =
                ContractVO(
                        contract.id,
                        contract.createdAt.toString(),
                        contract.updatedAt.toString(),
                        contract.billNumber
                )
    }

}

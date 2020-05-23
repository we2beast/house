package com.lab.house.hcs.services

import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.vo.contract.ContractCreateRq
import com.lab.house.hcs.vo.contract.ContractVO

interface ContractService {

    @Throws(EntityNotFoundException::class)
    fun getContractById(id: String): ContractVO

    @Throws(EntityNotFoundException::class)
    fun getContracts(): List<ContractVO>

    fun createContract(contractCreateRq: ContractCreateRq): ContractVO

    @Throws(EntityNotFoundException::class)
    fun updateContract(id: String, contractCreateRq: ContractCreateRq): ContractVO

    fun delete(id: String)

}

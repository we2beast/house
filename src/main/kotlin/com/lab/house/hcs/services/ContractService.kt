package com.lab.house.hcs.services

import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.vo.contract.ContractCreateRq
import com.lab.house.hcs.vo.contract.ContractVO
import com.lab.house.hcs.vo.hcs.HcsCreateRq
import com.lab.house.hcs.vo.hcs.HcsVO

interface ContractService {

    @Throws(EntityNotFoundException::class)
    fun getContractById(id: String): ContractVO

    @Throws(EntityNotFoundException::class)
    fun getContracts(): List<ContractVO>

    @Throws(EntityNotFoundException::class)
    fun createContract(contractCreateRq: ContractCreateRq): ContractVO

    @Throws(EntityNotFoundException::class)
    fun updateContract(id: String, contractCreateRq: ContractCreateRq): ContractVO

    @Throws(EntityNotFoundException::class)
    fun delete(id: String)

}

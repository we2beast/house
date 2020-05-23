package com.lab.house.hcs.services.impl

import com.lab.house.hcs.services.ContractService
import com.lab.house.hcs.vo.contract.ContractCreateRq
import com.lab.house.hcs.vo.contract.ContractVO
import org.springframework.stereotype.Service

@Service
class ContractServiceImpl : ContractService {
    override fun getContractById(id: String): ContractVO {
        TODO("Not yet implemented")
    }

    override fun getContracts(): List<ContractVO> {
        TODO("Not yet implemented")
    }

    override fun createContract(contractCreateRq: ContractCreateRq): ContractVO {
        TODO("Not yet implemented")
    }

    override fun updateContract(id: String, contractCreateRq: ContractCreateRq): ContractVO {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}

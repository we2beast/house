package com.lab.house.hcs.services.impl

import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.entities.Contract
import com.lab.house.hcs.repositories.ContractRepository
import com.lab.house.hcs.services.ContractService
import com.lab.house.hcs.vo.contract.ContractCreateRq
import com.lab.house.hcs.vo.contract.ContractVO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContractServiceImpl : ContractService {

    private val log = LoggerFactory.getLogger(ContractServiceImpl::class.java)

    @Autowired
    lateinit var contractRepository: ContractRepository

    @Throws(EntityNotFoundException::class)
    override fun getContractById(id: String): ContractVO = contractRepository.findById(id.toLong()).map(::toContractVO).orElseThrow { throw EntityNotFoundException("Contract with $id not found.") }

    @Throws(EntityNotFoundException::class)
    override fun getContracts(): List<ContractVO> {
        return contractRepository.findAll().map(::toContractVO)
    }

    override fun createContract(contractCreateRq: ContractCreateRq): ContractVO {
        val id = contractRepository.save(Contract().apply {
            billNumber = contractCreateRq.billNumber
        }).id ?: throw IllegalArgumentException("Bad id returned.")

        log.debug("Created entity $id")
        return getContractById(id.toString())
    }

    @Throws(EntityNotFoundException::class)
    override fun updateContract(id: String, contractCreateRq: ContractCreateRq): ContractVO {
        contractRepository.save(contractRepository.findById(id.toLong()).get().apply {
            billNumber = contractCreateRq.billNumber
        }).id ?: throw IllegalArgumentException("Bad id returned.")

        log.debug("Updated entity $id")
        return getContractById(id)
    }

    override fun delete(id: String) {
        contractRepository.deleteById(id.toLong())
        log.debug("Deleted entity $id")
    }

    private fun toContractVO(contract: Contract): ContractVO {
        return ContractVO.fromData(contract)
    }

}

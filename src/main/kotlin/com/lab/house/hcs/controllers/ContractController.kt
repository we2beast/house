package com.lab.house.hcs.controllers

import com.lab.house.core.controllers.BaseController
import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.services.ContractService
import com.lab.house.hcs.vo.contract.ContractCreateRq
import com.lab.house.hcs.vo.contract.ContractVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("api")
class ContractController : BaseController() {

    @Autowired
    lateinit var contractService: ContractService

    @GetMapping("/contracts")
    fun getContracts(): ResponseEntity<List<ContractVO>> = processServiceExceptions {
        try {
            ResponseEntity.ok(contractService.getContracts())
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Contracts Not Found", ex)
        }
    }

    @GetMapping("/contract/{id}")
    fun getContractById(@PathVariable id: String): ResponseEntity<ContractVO> = processServiceExceptions {
        try {
            ResponseEntity.ok(contractService.getContractById(id))
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Contract Not Found", ex)
        }
    }

    @PostMapping("/contract")
    fun createContract(@RequestBody contractCreateRq: ContractCreateRq): ResponseEntity<ContractVO> = processServiceExceptions {
        ResponseEntity.ok(contractService.createContract(contractCreateRq))
    }

    @PutMapping("/contract/{id}")
    fun updateContract(@PathVariable id: String, @RequestBody contractUpdateRq: ContractCreateRq): ResponseEntity<ContractVO> = processServiceExceptions {
        ResponseEntity.ok(contractService.updateContract(id, contractUpdateRq))
    }

    @DeleteMapping("/contract/{id}")
    fun deleteContract(@PathVariable id: String): ResponseEntity<*> = processServiceExceptions {
        ResponseEntity.ok(contractService.delete(id))
    }
    
}

package com.lab.house.hcs.controllers

import com.lab.house.core.controllers.BaseController
import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.services.ChargeService
import com.lab.house.hcs.vo.charge.ChargeCreateRq
import com.lab.house.hcs.vo.charge.ChargeVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("api")
class ChargeController : BaseController() {

    @Autowired
    lateinit var chargeService: ChargeService

    @GetMapping("/charges")
    fun getCharges(): ResponseEntity<List<ChargeVO>> = processServiceExceptions {
        try {
            ResponseEntity.ok(chargeService.getCharges())
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Charges Not Found", ex)
        }
    }

    @GetMapping("/charge/{id}")
    fun getChargeById(@PathVariable id: String): ResponseEntity<ChargeVO> = processServiceExceptions {
        try {
            ResponseEntity.ok(chargeService.getChargeById(id))
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Charge Not Found", ex)
        }
    }

    @PostMapping("/charge/{houseId}")
    fun createCharge(@PathVariable houseId: String, @RequestBody chargeCreateRq: ChargeCreateRq): ResponseEntity<ChargeVO> = processServiceExceptions {
        ResponseEntity.ok(chargeService.createCharge(houseId, chargeCreateRq))
    }

    @PutMapping("/charge/{id}")
    fun updateCharge(@PathVariable id: String, @RequestBody chargeUpdateRq: ChargeCreateRq): ResponseEntity<ChargeVO> = processServiceExceptions {
        ResponseEntity.ok(chargeService.updateCharge(id, chargeUpdateRq))
    }

    @DeleteMapping("/charge/{id}")
    fun deleteCharge(@PathVariable id: String): ResponseEntity<*> = processServiceExceptions {
        ResponseEntity.ok(chargeService.delete(id))
    }
    
}

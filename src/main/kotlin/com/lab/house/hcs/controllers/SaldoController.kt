package com.lab.house.hcs.controllers

import com.lab.house.core.controllers.BaseController
import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.services.SaldoService
import com.lab.house.hcs.vo.hcs.HcsCreateRq
import com.lab.house.hcs.vo.hcs.HcsVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("api")
class SaldoController : BaseController() {

    @Autowired
    lateinit var saldoService: SaldoService

    @GetMapping("/saldos")
    fun getSaldos(): ResponseEntity<List<HcsVO>> = processServiceExceptions {
        try {
            ResponseEntity.ok(saldoService.getSaldos())
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Saldos Not Found", ex)
        }
    }

    @GetMapping("/saldo/{id}")
    fun getSaldoById(@PathVariable id: String): ResponseEntity<HcsVO> = processServiceExceptions {
        try {
            ResponseEntity.ok(saldoService.getSaldoById(id))
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Saldo Not Found", ex)
        }
    }

    @PostMapping("/saldo")
    fun createSaldo(@RequestBody saldoCreateRq: HcsCreateRq): ResponseEntity<HcsVO> = processServiceExceptions {
        ResponseEntity.ok(saldoService.createSaldo(saldoCreateRq))
    }

    @PutMapping("/saldo/{id}")
    fun updateSaldo(@PathVariable id: String, @RequestBody saldoUpdateRq: HcsCreateRq): ResponseEntity<HcsVO> = processServiceExceptions {
        ResponseEntity.ok(saldoService.updateSaldo(id, saldoUpdateRq))
    }

    @DeleteMapping("/saldo/{id}")
    fun deleteSaldo(@PathVariable id: String): ResponseEntity<*> = processServiceExceptions {
        ResponseEntity.ok(saldoService.delete(id))
    }
    
}

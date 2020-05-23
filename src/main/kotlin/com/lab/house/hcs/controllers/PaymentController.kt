package com.lab.house.hcs.controllers

import com.lab.house.core.controllers.BaseController
import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.services.PaymentService
import com.lab.house.hcs.vo.hcs.HcsCreateRq
import com.lab.house.hcs.vo.hcs.HcsVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("api")
class PaymentController : BaseController() {

    @Autowired
    lateinit var paymentService: PaymentService

    @GetMapping("/payments")
    fun getPayments(): ResponseEntity<List<HcsVO>> = processServiceExceptions {
        try {
            ResponseEntity.ok(paymentService.getPayments())
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Payments Not Found", ex)
        }
    }

    @GetMapping("/payment/{id}")
    fun getPaymentById(@PathVariable id: String): ResponseEntity<HcsVO> = processServiceExceptions {
        try {
            ResponseEntity.ok(paymentService.getPaymentById(id))
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Payment Not Found", ex)
        }
    }

    @PostMapping("/payment")
    fun createPayment(@RequestBody paymentCreateRq: HcsCreateRq): ResponseEntity<HcsVO> = processServiceExceptions {
        ResponseEntity.ok(paymentService.createPayment(paymentCreateRq))
    }

    @PutMapping("/payment/{id}")
    fun updatePayment(@PathVariable id: String, @RequestBody paymentUpdateRq: HcsCreateRq): ResponseEntity<HcsVO> = processServiceExceptions {
        ResponseEntity.ok(paymentService.updatePayment(id, paymentUpdateRq))
    }

    @DeleteMapping("/payment/{id}")
    fun deletePayment(@PathVariable id: String): ResponseEntity<*> = processServiceExceptions {
        ResponseEntity.ok(paymentService.delete(id))
    }
    
}

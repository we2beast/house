package com.lab.house.hcs.controllers

import com.lab.house.core.controllers.BaseController
import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.services.PaymentService
import com.lab.house.hcs.vo.payment.PaymentCreateRq
import com.lab.house.hcs.vo.payment.PaymentVO
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
    fun getPayments(): ResponseEntity<List<PaymentVO>> = processServiceExceptions {
        try {
            ResponseEntity.ok(paymentService.getPayments())
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Payments Not Found", ex)
        }
    }

    @GetMapping("/payment/{id}")
    fun getPaymentById(@PathVariable id: String): ResponseEntity<PaymentVO> = processServiceExceptions {
        try {
            ResponseEntity.ok(paymentService.getPaymentById(id))
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Payment Not Found", ex)
        }
    }

    @PostMapping("/payment/{chargeId}")
    fun createPayment(@PathVariable chargeId: String, @RequestBody paymentCreateRq: PaymentCreateRq): ResponseEntity<PaymentVO> = processServiceExceptions {
        ResponseEntity.ok(paymentService.createPayment(chargeId, paymentCreateRq))
    }
    
}

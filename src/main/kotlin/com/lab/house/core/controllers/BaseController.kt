package com.lab.house.core.controllers

import com.lab.house.core.exceptions.AlreadyExistsException
import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.core.exceptions.PaymentException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

open class BaseController {

    private val log = LoggerFactory.getLogger(BaseController::class.java)

    protected fun <T> processServiceExceptions(block: () -> T) =
            try {
                block()
            } catch (e: EntityNotFoundException) {
                log.error("$e")
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found", e)
            } catch (e: AlreadyExistsException) {
                log.error("$e")
                throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity already exists", e)
            } catch (e: PaymentException) {
                log.error("$e")
                throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message, e)
            } catch (e: Exception) {
                log.error("$e")
                throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred processing the request", e)
            }

}

package com.lab.house.hcs.controllers

import com.lab.house.core.controllers.BaseController
import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.services.HouseService
import com.lab.house.hcs.vo.house.HouseCreateRq
import com.lab.house.hcs.vo.house.HouseVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("api")
class HouseController : BaseController() {

    @Autowired
    lateinit var houseService: HouseService

    @GetMapping("/houses")
    fun getHouses(): ResponseEntity<List<HouseVO>> = processServiceExceptions {
        try {
            ResponseEntity.ok(houseService.getHouses())
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Houses Not Found", ex)
        }
    }

    @GetMapping("/house/{id}")
    fun getHouseById(@PathVariable id: String): ResponseEntity<HouseVO> = processServiceExceptions {
        try {
            ResponseEntity.ok(houseService.getHouseById(id))
        } catch (ex: EntityNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "House Not Found", ex)
        }
    }

    @PostMapping("/house")
    fun createHouse(@RequestBody houseCreateRq: HouseCreateRq): ResponseEntity<HouseVO> = processServiceExceptions {
        ResponseEntity.ok(houseService.createHouse(houseCreateRq))
    }

    @PutMapping("/house/{id}")
    fun updateHouse(@PathVariable id: String, @RequestBody houseUpdateRq: HouseCreateRq): ResponseEntity<HouseVO> = processServiceExceptions {
        ResponseEntity.ok(houseService.updateHouse(id, houseUpdateRq))
    }
    
}

package com.lab.house.hcs.services

import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.vo.house.HouseCreateRq
import com.lab.house.hcs.vo.house.HouseVO

interface HouseService {

    @Throws(EntityNotFoundException::class)
    fun getHouseById(id: String): HouseVO

    @Throws(EntityNotFoundException::class)
    fun getHouses(): List<HouseVO>

    fun createHouse(houseCreateRq: HouseCreateRq): HouseVO

    @Throws(EntityNotFoundException::class)
    fun updateHouse(id: String, houseCreateRq: HouseCreateRq): HouseVO

    fun delete(id: String)

}

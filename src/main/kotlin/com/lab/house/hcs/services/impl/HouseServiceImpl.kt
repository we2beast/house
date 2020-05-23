package com.lab.house.hcs.services.impl

import com.lab.house.hcs.services.HouseService
import com.lab.house.hcs.vo.house.HouseCreateRq
import com.lab.house.hcs.vo.house.HouseVO
import org.springframework.stereotype.Service

@Service
class HouseServiceImpl : HouseService {
    override fun getHouseById(id: String): HouseVO {
        TODO("Not yet implemented")
    }

    override fun getHouses(): List<HouseVO> {
        TODO("Not yet implemented")
    }

    override fun createHouse(houseCreateRq: HouseCreateRq): HouseVO {
        TODO("Not yet implemented")
    }

    override fun updateHouse(id: String, houseCreateRq: HouseCreateRq): HouseVO {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}

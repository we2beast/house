package com.lab.house.hcs.services.impl

import com.lab.house.hcs.services.ChargeService
import com.lab.house.hcs.vo.hcs.HcsCreateRq
import com.lab.house.hcs.vo.hcs.HcsVO
import org.springframework.stereotype.Service

@Service
class ChargeServiceImpl : ChargeService {

    override fun getChargeById(id: String): HcsVO {
        TODO("Not yet implemented")
    }

    override fun getCharges(): List<HcsVO> {
        TODO("Not yet implemented")
    }

    override fun createCharge(chargeCreateRq: HcsCreateRq): HcsVO {
        TODO("Not yet implemented")
    }

    override fun updateCharge(id: String, chargeUpdateRq: HcsCreateRq): HcsVO {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

}

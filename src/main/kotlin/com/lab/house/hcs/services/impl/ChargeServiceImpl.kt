package com.lab.house.hcs.services.impl

import com.lab.house.hcs.services.ChargeService
import com.lab.house.hcs.vo.charge.ChargeCreateRq
import com.lab.house.hcs.vo.charge.ChargeVO
import org.springframework.stereotype.Service

@Service
class ChargeServiceImpl : ChargeService {

    override fun getChargeById(id: String): ChargeVO {
        TODO("Not yet implemented")
    }

    override fun getCharges(): List<ChargeVO> {
        TODO("Not yet implemented")
    }

    override fun createCharge(houseId: String, chargeCreateRq: ChargeCreateRq): ChargeVO {
        TODO("Not yet implemented")
    }

    override fun updateCharge(id: String, chargeUpdateRq: ChargeCreateRq): ChargeVO {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

}

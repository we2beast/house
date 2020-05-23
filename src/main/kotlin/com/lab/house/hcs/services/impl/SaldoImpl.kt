package com.lab.house.hcs.services.impl

import com.lab.house.hcs.services.Saldo
import com.lab.house.hcs.vo.hcs.HcsCreateRq
import com.lab.house.hcs.vo.hcs.HcsVO
import org.springframework.stereotype.Service

@Service
class SaldoImpl : Saldo {
    override fun getSaldoById(id: String): HcsVO {
        TODO("Not yet implemented")
    }

    override fun getSaldos(): List<HcsVO> {
        TODO("Not yet implemented")
    }

    override fun createSaldo(saldoCreateRq: HcsCreateRq): HcsVO {
        TODO("Not yet implemented")
    }

    override fun updateSaldo(id: String, saldoCreateRq: HcsCreateRq): HcsVO {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}

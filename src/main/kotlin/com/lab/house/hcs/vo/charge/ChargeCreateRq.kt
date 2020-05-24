package com.lab.house.hcs.vo.charge

import com.lab.house.hcs.entities.Month

data class ChargeCreateRq(
        val value: Double = 0.0,
        val year: Int = 0,
        val month: Month = Month.JANUARY
)

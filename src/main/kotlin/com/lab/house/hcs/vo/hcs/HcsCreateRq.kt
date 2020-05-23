package com.lab.house.hcs.vo.hcs

import com.lab.house.hcs.entities.Month

data class HcsCreateRq(
        val value: Double? = 0.0,
        val year: Int? = 0,
        val month: Month = Month.JANUARY
)

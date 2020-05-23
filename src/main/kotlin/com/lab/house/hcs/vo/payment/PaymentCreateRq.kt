package com.lab.house.hcs.vo.payment

import com.lab.house.hcs.entities.Month

data class PaymentCreateRq(
        val value: Double? = 0.0,
        val year: Int? = 0,
        val month: Month = Month.JANUARY
)

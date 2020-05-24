package com.lab.house.hcs.repositories

import com.lab.house.hcs.entities.Charge
import com.lab.house.hcs.entities.House
import com.lab.house.hcs.entities.Month
import com.lab.house.hcs.entities.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ChargeRepository : JpaRepository<Charge, Long> {

    fun findFirstByHouse(house: House): Charge?
    fun findFirstByIdAndCompletePaymentIsFalse(id: Long): Charge?
    fun findFirstByHouseAndMonthAndYear(house: House, month: Month, year: Int): Charge?
    fun findAllByMonthAndYear(month: Month, year: Int): List<Charge>

}

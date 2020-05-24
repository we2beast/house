package com.lab.house.hcs.repositories

import com.lab.house.hcs.entities.Charge
import com.lab.house.hcs.entities.Month
import com.lab.house.hcs.entities.Saldo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.Year

@Repository
interface SaldoRepository : JpaRepository<Saldo, Long> {

    fun findFirstByChargeAndMonthAndYear(charge: Charge, month: Month, year: Int): Saldo?
    fun findFirstByCharge(charge: Charge): Saldo?

}

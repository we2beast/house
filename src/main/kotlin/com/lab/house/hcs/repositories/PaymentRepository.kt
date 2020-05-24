package com.lab.house.hcs.repositories

import com.lab.house.hcs.entities.Charge
import com.lab.house.hcs.entities.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository : JpaRepository<Payment, Long> {

    fun findFirstByCharge(charge: Charge): Payment?
    fun findAllByCharge(charge: Charge): List<Payment>
    fun findFirstByChargeOrderByCreatedAtDesc(charge: Charge): Payment?

}

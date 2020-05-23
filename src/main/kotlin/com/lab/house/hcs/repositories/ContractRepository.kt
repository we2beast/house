package com.lab.house.hcs.repositories

import com.lab.house.hcs.entities.Contract
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContractRepository : JpaRepository<Contract, Long> {

    fun findFirstByBillNumber(billNumber: Int): Contract?

}

package com.lab.house.hcs.repositories

import com.lab.house.hcs.entities.Contract
import com.lab.house.hcs.entities.House
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HouseRepository : JpaRepository<House, Long> {

    fun findFirstByContract(contract: Contract): House?
    fun findFirstByHouseNumber(houseNumber: Int): House?

}

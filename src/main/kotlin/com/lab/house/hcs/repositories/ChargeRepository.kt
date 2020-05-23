package com.lab.house.hcs.repositories

import com.lab.house.hcs.entities.Charge
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ChargeRepository : JpaRepository<Charge, Long>

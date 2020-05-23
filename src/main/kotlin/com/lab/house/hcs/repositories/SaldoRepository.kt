package com.lab.house.hcs.repositories

import com.lab.house.hcs.entities.Saldo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaldoRepository : JpaRepository<Saldo, Long>

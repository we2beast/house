package com.lab.house.hcs.repositories

import com.lab.house.hcs.entities.Report
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReportRepository : JpaRepository<Report, Long>

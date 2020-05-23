package com.lab.house.hcs.services

import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.vo.report.ReportCreateRq
import com.lab.house.hcs.vo.report.ReportVO

interface ReportService {

    @Throws(EntityNotFoundException::class)
    fun getReportById(id: String): ReportVO

    @Throws(EntityNotFoundException::class)
    fun getReports(): List<ReportVO>

    @Throws(EntityNotFoundException::class)
    fun createReport(reportCreateRq: ReportCreateRq): ReportVO

    @Throws(EntityNotFoundException::class)
    fun updateReport(id: String, reportCreateRq: ReportCreateRq): ReportVO

    @Throws(EntityNotFoundException::class)
    fun delete(id: String)

}

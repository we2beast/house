package com.lab.house.hcs.services.impl

import com.lab.house.hcs.services.ReportService
import com.lab.house.hcs.vo.report.ReportCreateRq
import com.lab.house.hcs.vo.report.ReportVO
import org.springframework.stereotype.Service

@Service
class ReportServiceImpl : ReportService {
    override fun getReportById(id: String): ReportVO {
        TODO("Not yet implemented")
    }

    override fun getReports(): List<ReportVO> {
        TODO("Not yet implemented")
    }

    override fun createReport(reportCreateRq: ReportCreateRq): ReportVO {
        TODO("Not yet implemented")
    }

    override fun updateReport(id: String, reportCreateRq: ReportCreateRq): ReportVO {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}

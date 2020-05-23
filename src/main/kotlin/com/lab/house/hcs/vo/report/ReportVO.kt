package com.lab.house.hcs.vo.report

import com.lab.house.hcs.entities.*
import com.lab.house.hcs.vo.house.HouseVO
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.CascadeType
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.OneToOne

data class ReportVO(
        val id: Long? = null,
        val createdAt: String,
        val updatedAt: String,
        val saldos: MutableSet<Saldo> = mutableSetOf(),
        val charges: MutableSet<Charge> = mutableSetOf(),
        val payments: MutableSet<Payment> = mutableSetOf()
) {

        companion object {
//                fun fromData(report: Report): ReportVO =
//                        ReportVO(
//                                report.id,
//                                report.createdAt.toString(),
//                                report.updatedAt.toString(),
//                                report.saldos,
//                                report.charges,
//                                report.payments
//                        )
        }

}

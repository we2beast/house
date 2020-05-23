package com.lab.house.hcs.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Table(name = "charges")
@Entity
data class Charge(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @SequenceGenerator(name = "sequenceGenerator")
        var id: Long? = null,

        @CreationTimestamp
        var createdAt: Timestamp = Timestamp(0),

        @UpdateTimestamp
        var updatedAt: Timestamp = Timestamp(0),

        @Column(name = "value", nullable = false)
        var value: Double? = 0.0,

        @Column(name = "year", nullable = false)
        var year: Int? = 1970,

        @Enumerated(EnumType.STRING)
        @Column(name = "month", nullable = false)
        var month: Month = Month.JANUARY,

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "report_id", nullable = false)
        val report: Report

)

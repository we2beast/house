package com.lab.house.hcs.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Table(name = "payments")
@Entity
data class Payment(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @SequenceGenerator(name = "sequenceGenerator")
        val id: Long? = null,

        @CreationTimestamp
        val createdAt: Timestamp = Timestamp(0),

        @UpdateTimestamp
        val updatedAt: Timestamp = Timestamp(0),

        @Column(name = "value", nullable = false)
        val value: Double? = 0.0,

        @Column(name = "year", nullable = false)
        val year: Int? = 1970,

        @Enumerated(EnumType.STRING)
        @Column(name = "month", nullable = false)
        val month: Month = Month.JANUARY

)

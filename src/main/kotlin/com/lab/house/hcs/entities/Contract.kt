package com.lab.house.hcs.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Table(name = "contracts")
@Entity
data class Contract(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @SequenceGenerator(name = "sequenceGenerator")
        var id: Long? = null,

        @CreationTimestamp
        var createdAt: Timestamp = Timestamp(0),

        @UpdateTimestamp
        var updatedAt: Timestamp = Timestamp(0),

        @Column(name = "bill_number", nullable = false)
        var billNumber: Int? = 0,

        @OneToOne(mappedBy = "contract", fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
        var house: House? = null

)

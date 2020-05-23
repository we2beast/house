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
        val id: Long? = null,

        @CreationTimestamp
        val createdAt: Timestamp = Timestamp(0),

        @UpdateTimestamp
        val updatedAt: Timestamp = Timestamp(0),

        @Column(name = "bill_number")
        val billNumber: Int? = 0,

        @OneToOne(mappedBy = "house", fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
        val house: House? = null

)

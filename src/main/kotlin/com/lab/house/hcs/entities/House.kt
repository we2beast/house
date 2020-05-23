package com.lab.house.hcs.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Table(name = "houses")
@Entity
data class House(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @SequenceGenerator(name = "sequenceGenerator")
        val id: Long? = null,

        @CreationTimestamp
        val createdAt: Timestamp = Timestamp(0),

        @UpdateTimestamp
        val updatedAt: Timestamp = Timestamp(0),

        @Column(name = "house_number")
        val houseNumber: Int? = 0,

        @OneToOne(mappedBy = "contract", fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
        val contract: Contract? = null

)

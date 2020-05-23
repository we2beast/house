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
        var id: Long? = null,

        @CreationTimestamp
        var createdAt: Timestamp = Timestamp(0),

        @UpdateTimestamp
        var updatedAt: Timestamp = Timestamp(0),

        @Column(name = "house_number", nullable = false)
        var houseNumber: Int? = 0,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "contract_id")
        var contract: Contract? = null,

        @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
        var charge: MutableSet<Charge> = mutableSetOf()

)

package com.lab.house.hcs.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Table(name = "reports")
@Entity
data class Report(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @SequenceGenerator(name = "sequenceGenerator")
        val id: Long? = null,

        @CreationTimestamp
        val createdAt: Timestamp = Timestamp(0),

        @UpdateTimestamp
        val updatedAt: Timestamp = Timestamp(0),

        @OneToMany(mappedBy = "saldos", fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
        val saldos: MutableSet<Saldo> = mutableSetOf(),

        @OneToMany(mappedBy = "charges", fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
        val charges: MutableSet<Charge> = mutableSetOf(),

        @OneToMany(mappedBy = "payments", fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
        val payments: MutableSet<Payment> = mutableSetOf()

)

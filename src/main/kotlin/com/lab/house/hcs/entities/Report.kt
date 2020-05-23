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
        var id: Long? = null,

        @CreationTimestamp
        var createdAt: Timestamp = Timestamp(0),

        @UpdateTimestamp
        var updatedAt: Timestamp = Timestamp(0),

        @OneToMany(mappedBy = "report", fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
        var saldos: MutableSet<Saldo> = mutableSetOf(),

        @OneToMany(mappedBy = "report", fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
        var charges: MutableSet<Charge> = mutableSetOf(),

        @OneToMany(mappedBy = "report", fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
        var payments: MutableSet<Payment> = mutableSetOf()

)

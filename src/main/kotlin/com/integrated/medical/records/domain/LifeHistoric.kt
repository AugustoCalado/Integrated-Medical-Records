package com.integrated.medical.records.domain

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "LIFE_HISTORIC", schema = "MEDICAL_RECORDS")
data class LifeHistoric(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_LIFE_HISTORIC", nullable = false, unique = true)
        val idLifeHistoric: Int,

        @Column(name = "DESCRIPTION", length = 500)
        @NotNull
        val description: String

        ) {

    @ManyToOne
    @JoinColumn(name = "ID_PATIENT")
    lateinit var patient: Patient

}
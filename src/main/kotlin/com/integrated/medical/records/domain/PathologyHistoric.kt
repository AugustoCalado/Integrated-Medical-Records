package com.integrated.medical.records.domain

import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Table(name = "PATHOLOGY_HISTORIC", schema = "MEDICAL_RECORDS")
data class PathologyHistoric(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_PATHOLOGY_HISTORIC", nullable = false, unique = true)
        val idPathologyHistoric: Int,

        @Column(name = "NAME", length = 150)
        @NotNull
        val name:String,

        @Column(name = "OBSERVATION", length = 500)
        val observation: String,

        @Column(name = "WAS_IT_TREATED")
        @NotNull
        val wasItTreated: Boolean,

        @Column(name = "IDENTIFICATION_DATe")
        val dataVaccine: LocalDate

        ) {

    @ManyToOne
    @JoinColumn(name = "ID_PATIENT")
    lateinit var patient: Patient

}
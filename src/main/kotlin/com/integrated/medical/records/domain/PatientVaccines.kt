package com.integrated.medical.records.domain

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank


@Entity
@Table(name = "VACCINE_HAS_PATIENT", schema = "MEDICAL_RECORDS")
data class PatientVaccines(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "IDVACCINES_HAS_PATIENT", nullable = false, unique = true)
        val idPatientVaccines: Int,

        @ManyToOne
        @JoinColumn(name = "ID_VACCINE")
        @NotBlank
        val vaccine: Vaccine,

        @ManyToOne
        @JoinColumn(name = "ID_PATIENT")
        @NotBlank
        val patient: Patient,

        @Column(name = "DATA_IMMUNIZATION")
        @NotBlank
        val dataVaccine: LocalDate,

        @Column(name = "PLACE_VACCINE_APPLIED")
        val placeVaccineApplied: String


) : Serializable {
}
package com.integrated.medical.records.domain

import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "MEDICAL_PRESCRIPTION", schema = "MEDICAL_RECORDS")
data class MedicalPrescription(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_MEDICAL_PRESCRIPTION", nullable = false, unique = true)
        val idMedicalPrescription: Int,

        @Column(name = "PRESCRIPTION", length = 1050)
        @NotNull
        val prescription: String,

        @Column(name = "PRESCRIPTION_DATE")
        @NotNull
        val prescriptionDate: LocalDate
)
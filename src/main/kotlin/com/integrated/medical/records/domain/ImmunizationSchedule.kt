package com.integrated.medical.records.domain

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "IMMUNIZATION_SCHEDULE", schema = "MEDICAL_RECORDS")
data class ImmunizationSchedule(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idIMMUNIZATION_SCHEDULE", nullable = false, unique = true)
        val idVaccine: Int,

        @Column(name = "START_AGE", length = 3)
        @NotBlank
        val startAge: Int,

        @Column(name = "END_AGE", length = 3)
        @NotBlank
        val endAge: Int,

        @Column(name = "RECOMMENDED_DOSAGE", length = 2)
        @NotBlank
        val recomendedDosage: String,

        @ManyToOne(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "VACCINES_idVACCINES")
        val vaccine:Vaccines


) {
}
package com.integrated.medical.records.domain

import javax.persistence.*

@Entity
@Table(name = "IMMUNIZATION_SCHEDULE", schema = "MEDICAL_RECORDS")
data class ImmunizationSchedule(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idIMMUNIZATION_SCHEDULE")
        val idVaccine: Int,

        @Column(name = "START_AGE")
        val startAge: Int,

        @Column(name = "END_AGE")
        val endAge: Int,

        @Column(name = "RECOMMENDED_DOSAGE")
        val recomendedDosage: String,

        @ManyToOne(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "VACCINES_idVACCINES")
        val vaccine:Vaccines


) {
}
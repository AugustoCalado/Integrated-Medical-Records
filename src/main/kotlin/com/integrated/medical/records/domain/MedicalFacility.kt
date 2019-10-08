package com.integrated.medical.records.domain

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "MEDICAL_FACILITY", schema = "MEDICAL_RECORDS")
data class MedicalFacility(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_MEDICAL_FACILITY", nullable = false, unique = true)
        val idMedicalFacility: Int,

        @Column(name = "NAME", length = 200)
        @NotNull
        val name: String,

        @Column(name = "EXTRA_INFORMATION", length = 1050)
        val extraInformation: String?
) {

    @ManyToOne
    @JoinColumn(name = "ID_MEDICAL_RECORD")
    lateinit var medicalRecord: MedicalRecord


}
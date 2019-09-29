package com.integrated.medical.records.domain

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "DOCTOR_CREDENTIAL", schema = "MEDICAL_RECORDS")
data class DoctorCredential(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_DOCTOR_CREDENTIAL", nullable = false, unique = true)
        val idFamilyHistoric: Int,

        @Column(name = "NAME", length = 200)
        @NotNull
        val name: String,


        @Column(name = "CRM", length = 10)
        @NotNull
        val crm: String
) {
    @ManyToOne
    @JoinColumn(name = "ID_MEDICAL_RECORD")
    lateinit var medicalRecord: MedicalRecord
}
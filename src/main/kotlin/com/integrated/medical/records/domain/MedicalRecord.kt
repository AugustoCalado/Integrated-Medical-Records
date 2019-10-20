package com.integrated.medical.records.domain

import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Table(name = "MEDICAL_RECORD", schema = "MEDICAL_RECORDS")
data class MedicalRecord(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_MEDICAL_RECORD", nullable = false, unique = true)
        val idMedicalRecord: Int,

        @Column(name = "DOCTOR_CRM", length = 20)
        @NotNull
        val crm: String,

        @Column(name = "MAIN_COMPLAIN", length = 750)
        @NotNull
        val mainComplain: String,

        @Column(name = "CURRENT_DISEASE_INFORMATION", length = 750)
        @NotNull
        val currentDiseaseInfo: String,

        @Column(name = "PE_HEAD_NECK", length = 750)
        val peHeadNeck: String?,

        @Column(name = "PE_BREATHING_APPARATUS", length = 750)
        val peBreathingApparatus: String?,

        @Column(name = "PE_HEART_SYSTEM", length = 750)
        val peHeartSystem: String?,

        @Column(name = "PE_BODY_MEMBERS", length = 750)
        val peBodyMembers: String?,

        @Column(name = "PE_BONES_JOINTS", length = 750)
        val peBonesJoints: String?,

        @Column(name = "PE_NEUROLOGICAL", length = 750)
        val peNeurological: String?,

        @Column(name = "DIAGNOSTIC", length = 2050)
        @NotNull
        val diagnostic: String,

        @Column(name = "MEDICAL_RECORD_DATE")
        @NotNull
        val medicalRecordDate: LocalDate,

        @Column(name = "MEDICAL_RECORD_PLACE")
        @NotNull
        val medicalRecordPlace: String

) {

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "FK_MEDICAL_RECORD")
    var medicalExam: MutableList<MedicalExam>? = mutableListOf()

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "FK_MEDICAL_RECORD")
    var medicalPrescription: MutableList<MedicalPrescription>? = mutableListOf()

}
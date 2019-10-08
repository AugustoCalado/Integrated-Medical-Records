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

        @Column(name = "MAIN_COMPLAIN", length = 750)
        @NotNull
        val mainComplain: String,

        @Column(name = "CURRENT_DISEASE_INFORMATION", length = 750)
        @NotNull
        val currentDiseaseInfo: String,

        @Column(name = "DIRECTED_ANAMNESIS", length = 1050)
        @NotNull
        val directedAnamnesis: String,

        @Column(name = "ECTOSCOPY", length = 750)
        val ectoscopy: String?,

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
        val medicalRecordDate: LocalDate

) {

    // TODO self-relationship

    @ManyToOne
    @JoinColumn(name = "ID_PATIENT")
    lateinit var patient: Patient

    @OneToMany(mappedBy = "medicalRecord")
    lateinit var medicalExam: List<MedicalExam>

    @OneToMany(mappedBy = "medicalRecord")
    lateinit var medicalPrescription: List<MedicalPrescription>

    @OneToMany(mappedBy = "medicalRecord")
    lateinit var medicalFacility: List<MedicalFacility>

    // TODO maybe we have some problems with dis lateinit variable, since some of them are optional to be filled by the doctor
}
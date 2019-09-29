package com.integrated.medical.records.domain

import java.time.LocalDate
import javax.persistence.*


@Entity
@Table(name = "MEDICAL_RECORD", schema = "MEDICAL_RECORDS")
data class MedicalRecord(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_MEDICAL_RECORD", nullable = false, unique = true)
        val idMedicalRecord: Int,

        @Column(name = "MAIN_COMPLAIN", nullable = false, length = 750)
        val mainComplain: String,

        @Column(name = "CURRENT_DISEASE_INFORMATION", nullable = false, length = 750)
        val currentDiseaseInfo: String,

        @Column(name = "DIRECTED_ANAMNESIS", nullable = false, length = 1050)
        val directedAnamnesis: String,

        @Column(name = "ECTOSCOPY", length = 750)
        val ectoscopy: String,

        @Column(name = "PE_HEAD_NECK", length = 750)
        val peHeadNeck: String,

        @Column(name = "PE_BREATHING_APPARATUS", length = 750)
        val peBreathingApparatus: String,

        @Column(name = "PE_HEART_SYSTEM", length = 750)
        val peHeartSystem: String,

        @Column(name = "PE_BODY_MEMBERS", length = 750)
        val peBodyMembers: String,

        @Column(name = "PE_BONES_JOINTS", length = 750)
        val peBonesJoints: String,

        @Column(name = "PE_NEUROLOGICAL", length = 750)
        val peNeurological: String,

        @Column(name = "DIAGNOSTIC", nullable = false, length = 2050)
        val diagnostic: String,

        @Column(name = "MEDICAL_RECORD_DATE", nullable = false)
        val medicalRecordDate: LocalDate

) {

    // TODO self-relationship

    @ManyToOne
    @JoinColumn(name = "ID_PATIENT")
    lateinit var patient: Patient

    @OneToOne(mappedBy = "medicalRecord")
    lateinit var vitalSigns: VitalSigns
}
package com.integrated.medical.records.domain.dto

import java.time.LocalDate

class MedicalRecordDTO(

        val idMedicalRecord: Int,

        val crm: String,

        val mainComplain: String,

        val currentDiseaseInfo: String,

        val peHeadNeck: String,

        val peBreathingApparatus: String,

        val peHeartSystem: String,

        val peBodyMembers: String,

        val peBonesJoints: String,

        val peNeurological: String,

        val diagnostic: String,

        val medicalRecordDate: LocalDate,

        val medicalRecordPlace: String

) {

    val medicalExam: MutableList<MedicalExamDTO>? = mutableListOf()

    val medicalPrescription: MutableList<MedicalPrescriptionDTO>? = mutableListOf()

}
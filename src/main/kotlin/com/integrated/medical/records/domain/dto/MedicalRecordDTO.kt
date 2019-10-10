package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.*
import java.time.LocalDate

class MedicalRecordDTO(

        val idMedicalRecord: Int,

        val mainComplain: String,

        val currentDiseaseInfo: String,

        val directedAnamnesis: String,

        val ectoscopy: String,

        val peHeadNeck: String,

        val peBreathingApparatus: String,

        val peHeartSystem: String,

        val peBodyMembers: String,

        val peBonesJoints: String,

        val peNeurological: String,

        val diagnostic: String,

        val medicalRecordDate: LocalDate,

        //##
        val patient: PatientDTO,

        val doctorCredential: DoctorCredentialDTO,

        val vitalSigns: VitalSignsDTO,

        val medicalExam: List<MedicalExamDTO>? = null,

        val medicalPrescription: List<MedicalPrescriptionDTO>? = null,

        val medicalFacility: List<MedicalFacilityDTO>? = null


) {

}
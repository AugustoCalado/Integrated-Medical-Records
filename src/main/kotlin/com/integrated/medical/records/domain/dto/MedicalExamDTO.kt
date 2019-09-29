package com.integrated.medical.records.domain.dto

import java.io.Serializable
import java.time.LocalDate

class MedicalExamDTO (

        val idMedicalExam: Int,

        val examName: String,

        val examObservation: String,

        val prescriptionDate: LocalDate,

        val medicalRecord: MedicalRecordDTO

) : Serializable {

}

package com.integrated.medical.records.domain.dto

import java.io.Serializable
import java.time.LocalDate

class MedicalPrescriptionDTO(
        val idMedicalPrescription: Int,

        val prescription: String,

        val prescriptionDate: LocalDate,

        val medicalRecord: MedicalRecordDTO
) : Serializable {

}

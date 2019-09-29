package com.integrated.medical.records.domain.dto

import java.io.Serializable

class DoctorCredentialDTO(

        val idDoctorCredential: Int,

        val name: String,

        val crm: String,

        val medicalRecord: MedicalRecordDTO
): Serializable {

}

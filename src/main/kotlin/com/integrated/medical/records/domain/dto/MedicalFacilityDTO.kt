package com.integrated.medical.records.domain.dto

import java.io.Serializable

class MedicalFacilityDTO(

        val idMedicalFacility: Int,

        val name: String,

        val extraInformation: String,

        val medicalRecord: MedicalRecordDTO
) : Serializable {

}

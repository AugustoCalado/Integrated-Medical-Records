package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.Patient
import com.integrated.medical.records.domain.Vaccines
import java.time.LocalDate


data class PatientVaccinesDTO(

        val idPatientVaccines: Int,

        val vaccines: Vaccines,

        val patient: Patient,

        val dataVaccine: LocalDate,

        val placeVaccineApplied: String) {
}
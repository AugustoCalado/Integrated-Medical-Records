package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.Patient
import com.integrated.medical.records.domain.Vaccine
import java.time.LocalDate


data class PatientVaccinesDTO(

        val idPatientVaccines: Int,

        val vaccine: Vaccine,

        val patient: Patient,

        val dataVaccine: LocalDate,

        val placeVaccineApplied: String) {
}
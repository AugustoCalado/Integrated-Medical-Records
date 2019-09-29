package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.Patient
import com.integrated.medical.records.domain.Vaccine
import java.io.Serializable
import java.time.LocalDate


data class PatientVaccinesDTO(

        var idPatientVaccines: Int,

        var vaccine: Vaccine,

        var patient: Patient,

        var dataVaccine: LocalDate,

        var placeVaccineApplied: String
) : Serializable {
}
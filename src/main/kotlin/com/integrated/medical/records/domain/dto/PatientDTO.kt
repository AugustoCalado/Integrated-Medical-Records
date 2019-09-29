package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.HealthInsurance
import com.integrated.medical.records.domain.PatientVaccines
import com.integrated.medical.records.domain.User
import com.integrated.medical.records.enums.GenderTypes
import java.io.Serializable
import java.time.LocalDate

class PatientDTO(

        var idPatient: Int,

        var name: String,

        var cpf: String,

        var gender: GenderTypes,

        var birthDate: LocalDate,

        var birthPlace: String,

        var fatherName: String,

        var motherName: String,

        var user: User,

        var patientVaccines: List<PatientVaccines>,

        var healthInsurance: List<HealthInsurance>
) : Serializable {

}
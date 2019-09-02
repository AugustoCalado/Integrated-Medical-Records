package com.integrated.medical.records.domain.resource

import com.integrated.medical.records.domain.HealthInsurance
import com.integrated.medical.records.domain.Patient
import com.integrated.medical.records.domain.PatientVaccines
import com.integrated.medical.records.domain.User
import com.integrated.medical.records.enums.GenderTypes
import org.springframework.hateoas.ResourceSupport
import java.time.LocalDate

class PatientResource(
        val name: String,
        val cpf: String,
        val gender: GenderTypes,
        val birthDate: LocalDate,
        val birthPlace: String?,
        val fatherName: String?,
        val motherName: String?,
        val user: User,
        val patientVaccines: List<PatientVaccines>?,
        val healthInsurance: List<HealthInsurance>?
) : ResourceSupport() {

    constructor(s: Patient) : this(s.name, s.cpf, s.gender, s.birthDate, s.birthPlace, s.fatherName,
            s.motherName, s.user, s.patientVaccines, s.healthInsurance)

    init {
        // add(linkTo(methodOn(SessionController::class.java).getSession(id)).withSelfRel())
    }


}



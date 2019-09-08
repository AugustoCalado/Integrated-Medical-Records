package com.integrated.medical.records.domain.resource

import com.integrated.medical.records.domain.HealthInsurance
import com.integrated.medical.records.domain.Patient
import com.integrated.medical.records.domain.resource.assembler.HealthInsuranceResourceAssembler
import com.integrated.medical.records.domain.resource.assembler.PatientVaccinesResourceAssembler
import com.integrated.medical.records.domain.resource.assembler.UserResourceAssembler
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
        val user: UserResource,
        val patientVaccines: List<PatientVaccinesResource>?,
        val healthInsurance: List<HealthInsuranceResource>?
) : ResourceSupport() {

    constructor(s: Patient) : this(
            s.name,
            s.cpf,
            s.gender,
            s.birthDate,
            s.birthPlace,
            s.fatherName,
            s.motherName, userResourceAssembler.toResource(s.user),
            patientVaccinesResourceAssembler.toResources(s.patientVaccines),
            healthInsuranceResourceAssembler.toResources(s.healthInsurance)
    )

    companion object {
        val userResourceAssembler = UserResourceAssembler()
        val patientVaccinesResourceAssembler = PatientVaccinesResourceAssembler()
        val healthInsuranceResourceAssembler = HealthInsuranceResourceAssembler()

    }


}



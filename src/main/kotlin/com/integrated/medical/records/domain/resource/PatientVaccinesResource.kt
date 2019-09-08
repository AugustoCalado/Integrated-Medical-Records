package com.integrated.medical.records.domain.resource

import com.integrated.medical.records.domain.PatientVaccines
import com.integrated.medical.records.domain.Vaccine
import com.integrated.medical.records.domain.resource.assembler.PatientResourceAssembler
import com.integrated.medical.records.domain.resource.assembler.VaccinesResourceAssembler
import org.springframework.hateoas.ResourceSupport
import java.time.LocalDate

class PatientVaccinesResource(

        val vaccine: VaccineResource,

        val patient: PatientResource,

        val dataVaccine: LocalDate,

        val placeVaccineApplied: String
) : ResourceSupport() {

    constructor(patientVaccines: PatientVaccines) : this(
            vaccineResourceAssembler.toResource(patientVaccines.vaccine)!!,
            patientResourceAssembler.toResource(patientVaccines.patient),
            patientVaccines.dataVaccine,
            patientVaccines.placeVaccineApplied

    )

    companion object {
        val patientResourceAssembler = PatientResourceAssembler()
        val vaccineResourceAssembler = VaccinesResourceAssembler()
    }
}
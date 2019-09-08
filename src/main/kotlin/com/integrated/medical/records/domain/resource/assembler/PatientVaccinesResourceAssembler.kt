package com.integrated.medical.records.domain.resource.assembler

import com.integrated.medical.records.controller.PatientImmunizationController
import com.integrated.medical.records.domain.PatientVaccines
import com.integrated.medical.records.domain.resource.PatientVaccinesResource
import org.springframework.hateoas.mvc.ResourceAssemblerSupport

class PatientVaccinesResourceAssembler : ResourceAssemblerSupport<PatientVaccines, PatientVaccinesResource> {

    constructor() : super(PatientImmunizationController::class.java, PatientVaccinesResource::class.java)

    override fun instantiateResource(patientVaccine: PatientVaccines): PatientVaccinesResource {
        return PatientVaccinesResource(patientVaccine)
    }

    override fun toResource(p0: PatientVaccines): PatientVaccinesResource {
        return createResourceWithId(p0.idPatientVaccines, p0)
    }

}
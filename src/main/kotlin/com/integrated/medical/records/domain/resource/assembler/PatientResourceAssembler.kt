package com.integrated.medical.records.domain.resource.assembler

import com.integrated.medical.records.controller.PatientController
import com.integrated.medical.records.domain.Patient
import com.integrated.medical.records.domain.resource.PatientResource
import org.springframework.hateoas.mvc.ResourceAssemblerSupport

class PatientResourceAssembler : ResourceAssemblerSupport<Patient, PatientResource> {

    constructor() : super(PatientController::class.java, PatientResource::class.java)

    override fun instantiateResource(patient: Patient): PatientResource {
        return PatientResource(patient)
    }

    override fun toResource(patient: Patient): PatientResource {
        return createResourceWithId(patient.idPatient, patient)
    }

}
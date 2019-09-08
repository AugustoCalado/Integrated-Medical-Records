package com.integrated.medical.records.domain.resource.assembler

import com.integrated.medical.records.controller.VaccineController
import com.integrated.medical.records.domain.Vaccine
import com.integrated.medical.records.domain.resource.VaccineResource
import org.springframework.hateoas.mvc.ResourceAssemblerSupport

class VaccinesResourceAssembler : ResourceAssemblerSupport<Vaccine, VaccineResource> {

    constructor() : super(VaccineController::class.java, VaccineResource::class.java)

    override fun instantiateResource(vaccine: Vaccine?): VaccineResource? {
        return vaccine?.let { VaccineResource(it) }
    }

    override fun toResource(vaccine: Vaccine?): VaccineResource? {
        return vaccine?.let { createResourceWithId(it.idVaccine, it) }
    }

}
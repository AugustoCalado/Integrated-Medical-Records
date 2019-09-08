package com.integrated.medical.records.domain.resource.assembler

import com.integrated.medical.records.controller.HealthInsuranceController
import com.integrated.medical.records.domain.HealthInsurance
import com.integrated.medical.records.domain.resource.HealthInsuranceResource
import org.springframework.hateoas.mvc.ResourceAssemblerSupport

class HealthInsuranceResourceAssembler : ResourceAssemblerSupport<HealthInsurance, HealthInsuranceResource> {

    constructor() : super(HealthInsuranceController::class.java, HealthInsuranceResource::class.java)

    override fun instantiateResource(healthInsurance: HealthInsurance?): HealthInsuranceResource? {
        return healthInsurance?.let { HealthInsuranceResource(it) }
    }

    override fun toResource(healthInsurance: HealthInsurance?): HealthInsuranceResource? {
        return healthInsurance?.let { createResourceWithId(it.idHealthInsurance, it) }
    }
}
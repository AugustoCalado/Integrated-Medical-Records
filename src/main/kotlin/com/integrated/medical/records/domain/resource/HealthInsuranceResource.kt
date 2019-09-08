package com.integrated.medical.records.domain.resource

import com.integrated.medical.records.domain.HealthInsurance
import com.integrated.medical.records.domain.resource.assembler.PatientResourceAssembler
import org.springframework.hateoas.ResourceSupport

class HealthInsuranceResource(

        val healthInsuranceCompany: String,

        val healthInsuranceName: String,

        val insuranceCardNumber: String,

        val cardExpirationDate: Int,

        val patient: PatientResource

) : ResourceSupport() {

    constructor(healthInsurance: HealthInsurance) : this(
            healthInsurance.healthInsuranceCompany,
            healthInsurance.healthInsuranceName,
            healthInsurance.insuranceCardNumber,
            healthInsurance.cardExpirationDate,
            patientResourceAssembler.toResource(healthInsurance.patient)
    )

    companion object {

        val patientResourceAssembler = PatientResourceAssembler()

    }
}
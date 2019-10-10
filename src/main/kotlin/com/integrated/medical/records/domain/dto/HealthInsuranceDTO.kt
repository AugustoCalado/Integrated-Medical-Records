package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.Patient

class HealthInsuranceDTO(

        val idHealthInsurance: Int,

        val healthInsuranceCompany: String,

        val healthInsuranceName: String,

        val insuranceCardNumber: String,

        val cardExpirationDate: Int,
        //042021 == 04/2021
        var patient: PatientDTO?

) {

}

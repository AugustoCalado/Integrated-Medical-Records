package com.integrated.medical.records.service

import com.integrated.medical.records.domain.dto.HealthInsuranceDTO

interface HealthInsuranceService{

    fun insertNewHealthInsurance(cpf:String, healthInsuranceDTO: HealthInsuranceDTO)

    fun updateHealthInsurance(idHealthInsurance: Int, healthInsuranceDTO:HealthInsuranceDTO)

    fun deleteHealthInsurance(idHealthInsurance: Int)
}
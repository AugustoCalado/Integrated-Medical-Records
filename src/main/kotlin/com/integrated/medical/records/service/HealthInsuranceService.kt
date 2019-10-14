package com.integrated.medical.records.service

import com.integrated.medical.records.domain.dto.HealthInsuranceDTO
import org.springframework.stereotype.Service

@Service
interface HealthInsuranceService{

    fun insertNewHealthInsurance(cpf:String, healthInsuranceDTO: HealthInsuranceDTO)

    fun updateHealthInsurance(idHealthInsurance: Int, healthInsuranceDTO:HealthInsuranceDTO)

    fun deleteHealthInsurance(idHealthInsurance: Int)
}
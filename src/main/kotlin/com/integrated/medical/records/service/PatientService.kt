package com.integrated.medical.records.service

import com.integrated.medical.records.domain.dto.PatientDTO
import org.springframework.stereotype.Service

@Service
interface PatientService {
    fun getAllPatients(): List<PatientDTO>?
    fun getPatientWithName(name:String):List<PatientDTO>
    fun findPatientByCpf(cpf: String): PatientDTO?
    fun updatePatient(patient: PatientDTO, cpf: String)
}
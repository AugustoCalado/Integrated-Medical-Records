package com.integrated.medical.records.service

import com.integrated.medical.records.domain.dto.PatientDTO
import com.integrated.medical.records.domain.dto.PatientHistoricDTO
import org.springframework.stereotype.Service

@Service
interface PatientService {
    fun getAllPatients(): List<PatientDTO>
    fun findPatientByCpf(cpf: String): PatientDTO
    fun addNewPatient(patient: PatientDTO)
    fun updatePatient(patient: PatientDTO, cpf: String): PatientDTO

    fun addPatientHistoric(patientHistoricDTO: PatientHistoricDTO, cpf: String): PatientDTO
    fun getPatientHistorics(cpf: String): List<PatientHistoricDTO>

//
//    fun addPatientMedicalExam(patientHistoricDTO: PatientHistoricDTO, cpf: String)
//    fun getPatientMedicalExam(cpf: String): List<PatientHistoricDTO>?
}
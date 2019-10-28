package com.integrated.medical.records.service

import com.integrated.medical.records.domain.dto.PatientDTO
import com.integrated.medical.records.domain.dto.PatientVaccinesDTO
import org.springframework.stereotype.Service

@Service
interface PatientImmunizationService {
    fun findAllPatientImmunization(cpf: String): List<PatientVaccinesDTO>
    fun insertPatientImmunization(cpf: String, patientVaccinesDTO: PatientVaccinesDTO): PatientDTO
    fun findPatientImmunization(idPatient: Int, idPatientVaccines: Int): PatientVaccinesDTO
    fun deletePattientImmunization(cpf: String, idPatientVaccines: Int): PatientDTO
    fun getAllPatientImmunizationFromDB(): List<PatientVaccinesDTO>
}

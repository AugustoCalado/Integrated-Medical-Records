package com.integrated.medical.records.service

import com.integrated.medical.records.domain.dto.PatientVaccinesDTO
import org.springframework.stereotype.Service

@Service
interface PatientImmunizationService {
    fun findAllPatientImmunization(cpf: String): List<PatientVaccinesDTO>
    fun insertPatientImmunization()
    fun findPatientImmunization(idPatient: Int, idPatientVaccines: Int):PatientVaccinesDTO
    fun deletePattientImmunization()
}

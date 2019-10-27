package com.integrated.medical.records.service

import com.integrated.medical.records.domain.dto.EmergencyCardDTO
import com.integrated.medical.records.domain.dto.PatientDTO
import org.springframework.stereotype.Service

@Service
interface EmergencyCardService {
    fun getEmergencyCardItens(patientCPF: String): List<EmergencyCardDTO>
    fun insertEmergencyCardItem(patientCPF: String, emergencyCardItem: EmergencyCardDTO): PatientDTO
    fun updateEmergencyCardItem(emergencyCardItem: EmergencyCardDTO): EmergencyCardDTO
    fun deleteEmergencyCardItem(idEmergencyCardItem: Int)
}
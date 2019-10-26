package com.integrated.medical.records.service

import com.integrated.medical.records.domain.EmergencyCard
import com.integrated.medical.records.domain.dto.UserDTO
import org.springframework.stereotype.Service

@Service
interface EmergencyCardService {
    fun getEmergencyCardItens(patientCPF: String): List<EmergencyCard>
    fun insertEmergencyCardItem(patientCPF: String, emergencyCardItem:EmergencyCard)
    fun updateEmergencyCardItem(idEmergencyCard: Long)
}
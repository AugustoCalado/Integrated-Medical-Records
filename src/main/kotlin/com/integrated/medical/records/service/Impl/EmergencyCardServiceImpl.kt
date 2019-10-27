package com.integrated.medical.records.service.Impl

import com.integrated.medical.records.domain.EmergencyCard
import com.integrated.medical.records.domain.dto.EmergencyCardDTO
import com.integrated.medical.records.domain.dto.PatientDTO
import com.integrated.medical.records.domain.dto.toEntity
import com.integrated.medical.records.domain.toDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.repository.EmergencyCardRepository
import com.integrated.medical.records.repository.PatientRepository
import com.integrated.medical.records.service.EmergencyCardService

import org.springframework.stereotype.Service

@Service
class EmergencyCardServiceImpl(
        val emergencyCardRepository: EmergencyCardRepository,
        val patientRepository: PatientRepository
) : EmergencyCardService {

    @Throws(ObjectNotFoundException::class)
    override fun getEmergencyCardItens(patientCPF: String): List<EmergencyCardDTO> {

        val patient = patientRepository.findByCpf(patientCPF)
                ?: throw ObjectNotFoundException("Patient not found")
        patient.emergencyCard?.let {
            return EmergencyCard.entityListToDtoList(it)
        }
        return emptyList()
    }

    override fun getEmergencyCardSingleItem(idEmergencyCardItem: Int): EmergencyCardDTO {

        val emergencyCard = emergencyCardRepository.findById(idEmergencyCardItem).orElseThrow {
            ObjectNotFoundException("Emergency Card not found")
        }
        return emergencyCard.toDTO()
    }

    @Throws(ObjectNotFoundException::class)
    override fun insertEmergencyCardItem(patientCPF: String, emergencyCardItem: EmergencyCardDTO): PatientDTO {

        val patient = patientRepository.findByCpf(patientCPF)
                ?: throw ObjectNotFoundException("Patient not found")
        patient.emergencyCard?.let {
            it.add(emergencyCardItem.toEntity())
        }
        return patientRepository.save(patient).toDTO()
    }

    @Throws(ObjectNotFoundException::class)
    override fun updateEmergencyCardItem(emergencyCardItemDTO: EmergencyCardDTO): EmergencyCardDTO {

        emergencyCardRepository.findById(emergencyCardItemDTO.idEmergencyCardDTO).orElseThrow {
            throw ObjectNotFoundException("Emergency Card not found")
        }
        return emergencyCardRepository.save(emergencyCardItemDTO.toEntity()).toDTO()
    }

    override fun deleteEmergencyCardItem(idEmergencyCardItem: Int) {
        //TODO induce an error to test functionality
        emergencyCardRepository.deleteById(idEmergencyCardItem)
    }


}
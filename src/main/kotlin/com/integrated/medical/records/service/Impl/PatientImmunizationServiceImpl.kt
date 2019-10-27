package com.integrated.medical.records.service.Impl

import com.integrated.medical.records.domain.PatientVaccines
import com.integrated.medical.records.domain.dto.PatientDTO
import com.integrated.medical.records.domain.dto.PatientVaccinesDTO
import com.integrated.medical.records.domain.dto.toEntity
import com.integrated.medical.records.domain.toDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.repository.PatientRepository
import com.integrated.medical.records.repository.PatientVaccinesRepository
import com.integrated.medical.records.service.PatientImmunizationService
import org.springframework.stereotype.Service

@Service
class PatientImmunizationServiceImpl(
        val patientRepository: PatientRepository,
        val patientVaccinesRepository: PatientVaccinesRepository
) : PatientImmunizationService {

    @Throws(ObjectNotFoundException::class)
    override fun findAllPatientImmunization(cpf: String): List<PatientVaccinesDTO> {

        val patient = patientRepository.findByCpf(cpf)
                ?: throw ObjectNotFoundException("Patient not found")
        patient.patientVaccines?.let {
            return PatientVaccines.entityListToDtoList(it)
        }
        return emptyList()
    }

    @Throws(ObjectNotFoundException::class)
    override fun insertPatientImmunization(cpf: String, patientVaccinesDTO: PatientVaccinesDTO): PatientDTO {

        val patient = patientRepository.findByCpf(cpf)
                ?: throw ObjectNotFoundException("Patient not found")
        patient.patientVaccines?.let {
            it.add(patientVaccinesDTO.toEntity())
        }
        return patientRepository.save(patient).toDTO()
    }

    @Throws(ObjectNotFoundException::class)
    override fun findPatientImmunization(idPatient: Int, idPatientVaccines: Int): PatientVaccinesDTO {

        val patientVaccines = patientVaccinesRepository.findById(idPatientVaccines).orElseThrow {
            throw ObjectNotFoundException("PatientImmunization not found")
        }

        return patientVaccines.toDTO()
    }

    @Throws(Exception::class)
    override fun deletePattientImmunization(cpf: String, idPatientVaccines: Int): PatientDTO {
        //TODO induce an error to test functionality
        patientVaccinesRepository.deleteById(idPatientVaccines)
        val patient = patientRepository.findByCpf(cpf) ?: throw ObjectNotFoundException("Patient not found")
        return patient.toDTO()
    }
}
package com.integrated.medical.records.service.Impl

import com.integrated.medical.records.domain.PatientHistoric
import com.integrated.medical.records.domain.dto.PatientDTO
import com.integrated.medical.records.domain.dto.PatientHistoricDTO
import com.integrated.medical.records.domain.dto.toEntity
import com.integrated.medical.records.domain.toDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.repository.PatientRepository
import com.integrated.medical.records.service.PatientService
import org.springframework.stereotype.Service

@Service
class PatientServiceImpl(val patientRepository: PatientRepository) : PatientService {

    @Throws(ObjectNotFoundException::class)
    override fun findPatientByCpf(cpf: String): PatientDTO {

        val patient = patientRepository.findByCpf(cpf)
                ?: throw ObjectNotFoundException("Patient not found")
        patient?.let {
            return it.toDTO()
        }
    }

    @Throws(ObjectNotFoundException::class)
    override fun updatePatient(patient: PatientDTO, cpf: String): PatientDTO {

        patientRepository.findByCpf(cpf) ?: throw ObjectNotFoundException("Patient not found")
        return patientRepository.save(patient.toEntity()).toDTO()
    }

    override fun getAllPatients(): List<PatientDTO> {

        var listOfPatients = patientRepository.findAll()
        return listOfPatients.toList().toDTO()

    }

    @Throws(Exception::class)
    override fun addNewPatient(patient: PatientDTO) {
        val patientFromDB = patientRepository.findByCpf(patient.cpf)

        if (patientFromDB != null) {
            //TODO Verify This condition
            throw Exception("Patient already exist")
        }

        patientRepository.save(patient.toEntity())
    }

//
    @Throws(ObjectNotFoundException::class)
    override fun addPatientHistoric(patientHistoricDTO: PatientHistoricDTO, cpf: String): PatientDTO {

        val patient = patientRepository.findByCpf(cpf)
                ?: throw ObjectNotFoundException("Patient not found")
        patient.patientHistoric?.let {
            it.add(patientHistoricDTO.toEntity())
        }
        return patientRepository.save(patient).toDTO()
    }

    @Throws(ObjectNotFoundException::class)
    override fun getPatientHistorics(cpf: String): List<PatientHistoricDTO> {

        val patient = patientRepository.findByCpf(cpf)
                ?: throw ObjectNotFoundException("Patient not found")
        patient.patientHistoric?.let {
            return PatientHistoric.entityListToDtoList(it)
        }
        return emptyList()
    }

}
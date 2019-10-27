package com.integrated.medical.records.service.Impl

import com.integrated.medical.records.domain.MedicalRecord
import com.integrated.medical.records.domain.dto.MedicalRecordDTO
import com.integrated.medical.records.domain.dto.PatientDTO
import com.integrated.medical.records.domain.dto.toEntity
import com.integrated.medical.records.domain.toDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.repository.MedicalRecordRepository
import com.integrated.medical.records.repository.PatientRepository
import com.integrated.medical.records.service.MedicalRecordService
import org.springframework.stereotype.Service

@Service
class MedicalRecordServiceImpl(
        val medicalRecordRepository: MedicalRecordRepository,
        val patientRepository: PatientRepository
) : MedicalRecordService {

    @Throws(ObjectNotFoundException::class)
    override fun getAllMedicalRecords(patientCPF: String): List<MedicalRecordDTO> {

        val patient = patientRepository.findByCpf(patientCPF)
                ?: throw ObjectNotFoundException("Patient not found")
        patient.medicalRecord?.let {
            return MedicalRecord.entityListToDtoList(it)
        }
        return emptyList()
    }

    @Throws(ObjectNotFoundException::class)
    override fun getMedicalRecord(idMedicalRecord: Int): MedicalRecordDTO {

        val medicalRecord = medicalRecordRepository.findById(idMedicalRecord).orElseThrow {
            ObjectNotFoundException("Medical Record not found")
        }
        return medicalRecord.toDTO()
    }

    @Throws(ObjectNotFoundException::class)
    override fun insertMedicalRecord(patientCPF: String, medicalRecordDTO: MedicalRecordDTO): PatientDTO {

        val patient = patientRepository.findByCpf(patientCPF)
                ?: throw ObjectNotFoundException("Patient not found")
        patient.medicalRecord?.let {
            it.add(medicalRecordDTO.toEntity())
        }
        return patientRepository.save(patient).toDTO()
    }

    override fun deleteMedicalRecord(idMedicalRecord: Int) {
        //TODO induce an error to test functionality
        medicalRecordRepository.deleteById(idMedicalRecord)
    }


}
package com.integrated.medical.records.service

import com.integrated.medical.records.domain.dto.EmergencyCardDTO
import com.integrated.medical.records.domain.dto.MedicalRecordDTO
import com.integrated.medical.records.domain.dto.PatientDTO
import org.springframework.stereotype.Service

@Service
interface MedicalRecordService {
    fun getAllMedicalRecords(patientCPF: String): List<MedicalRecordDTO>
    fun getMedicalRecord(idMedicalRecord: Int): MedicalRecordDTO
    fun insertMedicalRecord(patientCPF: String, medicalRecordDTO: MedicalRecordDTO): PatientDTO
    fun deleteMedicalRecord(idMedicalRecord: Int)
    fun getAllMedicalRecordsFromDB(): List<MedicalRecordDTO>
}
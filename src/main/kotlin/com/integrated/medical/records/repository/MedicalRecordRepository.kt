package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.MedicalRecord
import com.integrated.medical.records.domain.Patient
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@RepositoryRestResource
interface MedicalRecordRepository : CrudRepository<MedicalRecord, Int> {

    fun findByPatient(patient: Patient): List<MedicalRecord>
}
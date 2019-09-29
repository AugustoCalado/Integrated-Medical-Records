package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.MedicalRecord
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@RepositoryRestResource
//@Repository
interface MedicalRecordRepository : CrudRepository<MedicalRecord, Int> {

}
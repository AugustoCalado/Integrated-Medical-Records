package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.MedicalPrescription
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface MedicalPrescriptionRepository : CrudRepository<MedicalPrescription, Int> {
}
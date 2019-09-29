package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.HealthInsurance
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HealthInsuranceRepository : CrudRepository<HealthInsurance, Int> {
}
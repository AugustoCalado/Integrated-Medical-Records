package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.HealthInsurance
import org.springframework.data.repository.CrudRepository

interface HealthInsuranceRepository : CrudRepository<HealthInsurance, Int> {
}
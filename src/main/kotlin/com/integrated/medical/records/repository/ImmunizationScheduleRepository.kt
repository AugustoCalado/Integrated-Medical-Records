package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.ImmunizationSchedule
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ImmunizationScheduleRepository : CrudRepository<ImmunizationSchedule, Int> {
}
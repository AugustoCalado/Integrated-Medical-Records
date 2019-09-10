package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.ImmunizationSchedule
import org.springframework.data.repository.CrudRepository

interface ImmunizationScheduleRepository : CrudRepository<ImmunizationSchedule, Int> {
}
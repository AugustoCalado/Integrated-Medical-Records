package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.MedicalRecord
import com.integrated.medical.records.domain.VitalSigns
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VitalSignsRepository : CrudRepository<VitalSigns, Int> {}
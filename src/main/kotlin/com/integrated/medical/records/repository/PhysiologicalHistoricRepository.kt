package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.PhysiologicalHistoric
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@RepositoryRestResource
interface PhysiologicalHistoricRepository : CrudRepository<PhysiologicalHistoric, Int> {
}
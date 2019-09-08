package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.Vaccine
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VaccineRepository : CrudRepository<Vaccine,Int>{
}
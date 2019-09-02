package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.Patient
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepository: CrudRepository<Patient,Int>{

    fun findByName(name:String)

    fun findAllByBirthDateNotNull():List<Patient>
}
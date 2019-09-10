package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.Patient
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

//@RepositoryRestResource
@Repository
interface PatientRepository: CrudRepository<Patient,Int>{
//    @RestResource(path = "names", rel = "name")
    fun findByName(name:String)

    fun findAllByBirthDateNotNull():List<Patient>
}
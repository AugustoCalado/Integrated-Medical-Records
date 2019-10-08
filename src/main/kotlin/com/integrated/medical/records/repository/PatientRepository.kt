package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.Patient
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface PatientRepository : CrudRepository<Patient, Int> {
    //    @RestResource(path = "names", rel = "name")
    fun findByCpf(cpf: String): Patient

    fun findAllByBirthDateNotNull(): List<Patient>
}
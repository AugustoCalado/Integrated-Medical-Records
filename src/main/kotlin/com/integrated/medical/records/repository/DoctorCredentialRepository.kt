package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.DoctorCredential
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface DoctorCredentialRepository : CrudRepository<DoctorCredential, Int> {

    fun findByCrm(crm: String)
}
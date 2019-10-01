package com.integrated.medical.records.repository

import com.integrated.medical.records.domain.DoctorCredential
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctorCredentialRepository : CrudRepository<DoctorCredential, Int> {

    fun findByCrm(crm: String)
}
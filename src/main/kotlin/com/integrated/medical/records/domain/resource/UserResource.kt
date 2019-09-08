package com.integrated.medical.records.domain.resource

import com.integrated.medical.records.domain.User
import com.integrated.medical.records.domain.resource.assembler.PatientResourceAssembler
import org.springframework.hateoas.ResourceSupport

class UserResource(

        val nameLogin: String,

        val email: String,

        val password: String,

        val cellPhone: String,

        val patient:PatientResource




) : ResourceSupport() {

    constructor(u: User) : this(
            u.nameLogin,
            u.email,
            u.password,
            u.cellPhone,
            patientResourceAssembler.toResource(u.patient)

    )

    companion object {
        val patientResourceAssembler = PatientResourceAssembler()

    }
}
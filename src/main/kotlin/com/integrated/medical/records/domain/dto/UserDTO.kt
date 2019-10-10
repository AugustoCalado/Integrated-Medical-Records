package com.integrated.medical.records.domain.dto

import java.io.Serializable

class UserDTO(
        var idUser: Int,

        var nameLogin: String,

        var email: String,

        var password: String,

        var cellPhone: String,

        var patient: PatientDTO

) : Serializable {
}
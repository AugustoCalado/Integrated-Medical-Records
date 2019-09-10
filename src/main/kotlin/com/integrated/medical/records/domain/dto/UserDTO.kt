package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.Patient

class UserDTO(
        var idUser: Int,

        var nameLogin: String,

        var email: String,

        var password: String,

        var cellPhone: String,

        var patient: Patient

) {
}
package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.Patient

class UserDTO(
        val idUser: Int,

        val nameLogin: String,

        val email: String,

        val password: String,

        val cellPhone: String,

        val patient: Patient

) {
}
package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.User
import java.io.Serializable

class UserDTO(
        var idUser: Int = 0,

        val nameLogin: String = "",

        val email: String = "",

        var password: String = "",

        var cellPhone: String? = "",

        val patient: PatientDTO? = null

) : Serializable {

}


fun UserDTO.toEntity() : User {

    var user =  User(
            this.idUser,
            this.nameLogin,
            this.email,
            this.password,
            this.cellPhone
    )
    user.patient = this.patient!!.toEntity()

    return user
}
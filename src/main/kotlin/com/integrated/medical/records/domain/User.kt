package com.integrated.medical.records.domain

import com.integrated.medical.records.domain.dto.UserDTO
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "USER", schema = "MEDICAL_RECORDS")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_USER", nullable = false, unique = true)
        val idUser: Int,

        @Column(name = "NAME_LOGIN", length = 60)
        @NotBlank
        val nameLogin: String,

        @Column(name = "EMAIL", length = 60)
        @NotBlank
        val email: String,

        @Column(name = "PASSWORD", length = 60)
        @NotBlank
        val password: String,

        @Column(name = "CELL_PHONE", length = 14)
        val cellPhone: String?
) {
/*
    @OneToOne
    @JoinColumn(name = "ID_PATIENT")
    lateinit var patient: Patient*/
}

fun User.toDTO(): UserDTO {

    var userDTO = UserDTO(
            this.idUser,
            this.nameLogin,
            this.email,
            this.password,
            this.cellPhone
//            this.patient.toDTO()
    )

    return userDTO
}
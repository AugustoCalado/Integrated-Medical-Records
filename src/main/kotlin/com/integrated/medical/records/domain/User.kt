package com.integrated.medical.records.domain

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "USERS", schema = "MEDICAL_RECORDS")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idUSERS", nullable = false, unique = true)
        val idUser: Int,

        @Column(name = "NAME_LOGIN")
        @NotBlank
        val nameLogin: String,

        @Column(name = "EMAIL")
        @NotBlank
        val email: String,

        @Column(name = "PASSWORD")
        @NotBlank
        val password: String,

        @Column(name = "CELL_PHONE")
        val cellPhone:String
) {
        @OneToOne
        @JoinColumn(name = "PATIENTS_idPATIENTS")
        lateinit var patient: Patient
}
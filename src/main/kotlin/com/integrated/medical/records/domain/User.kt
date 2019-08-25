package com.integrated.medical.records.domain

import javax.persistence.*

@Entity
@Table(name = "USERS", schema = "MEDICAL_RECORDS")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idUSERS", nullable = false, unique = true)
        val idUser: Int,

        @Column(name = "NAME_LOGIN")
        val nameLogin: String,

        @Column(name = "EMAIL")
        val email: String,

        @Column(name = "PASSWORD")
        val password: String,

        @Column(name = "CELL_PHONE")
        val cellPhone:String
) {
        @OneToOne
        @JoinColumn(name = "PATIENTS_idPATIENTS")
        lateinit var patient: Patient
}
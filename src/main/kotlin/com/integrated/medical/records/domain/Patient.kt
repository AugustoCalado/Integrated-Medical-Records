package com.integrated.medical.records.domain

import com.integrated.medical.records.enums.GenderTypes
import javax.persistence.*

@Entity
@Table(name = "PATIENTS", schema = "MEDICAL_RECORDS")
data class Patient(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idPATIENTS", nullable = false, unique = true)
        val idPatient: Int,

        @Column(name = "NAME")
        val name: String,

        @Column(name = "CPF")
        val cpf: String,

        @Column(name = "GENDER")
        val gender: GenderTypes,

        @Temporal(value = TemporalType.DATE)
        @Column(name = "BIRTHDATE", insertable = false, updatable = false)
        val birthDate: java.util.Date,

        @Column(name = "BIRTHDATE")
        val birthPlace: String,

        @Column(name = "FATHER_NAME")
        val fatherName: String,

        @Column(name = "MOTHER_NAME")
        val motherName: String
) {

    @OneToOne(mappedBy = "patient")
    lateinit var user: List<User>

    @OneToMany(mappedBy = "patient")
    lateinit var patientVaccines: List<PatientVaccines>

    @OneToMany(mappedBy = "patient")
    lateinit var healthInsurance: List<HealthInsurance>
}
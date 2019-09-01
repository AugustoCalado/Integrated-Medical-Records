package com.integrated.medical.records.domain

import com.integrated.medical.records.enums.GenderTypes
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "PATIENTS", schema = "MEDICAL_RECORDS")
data class Patient(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idPATIENTS", nullable = false, unique = true)
        val idPatient: Int,

        @Column(name = "NAME", length = 150)
        @NotBlank
        val name: String,

        @Column(name = "CPF", length = 10)
        @NotBlank
        val cpf: String,

        @Column(name = "GENDER")
        @NotBlank
        val gender: GenderTypes,

//        @Temporal(value = TemporalType.DATE)
        @Column(name = "BIRTHDATE", insertable = false, updatable = false)
        @NotNull
        val birthDate: LocalDate,

        @Column(name = "BIRTHPLACE", length = 300)
        val birthPlace: String,

        @Column(name = "FATHER_NAME", length = 150)
        val fatherName: String,

        @Column(name = "MOTHER_NAME", length = 150)
        val motherName: String
) {

    @OneToOne(mappedBy = "patient")
    lateinit var user: User

    @OneToMany(mappedBy = "patient")
    lateinit var patientVaccines: List<PatientVaccines>

    @OneToMany(mappedBy = "patient")
    lateinit var healthInsurance: List<HealthInsurance>
}
package com.integrated.medical.records.domain

import com.integrated.medical.records.enums.GenderTypes
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "PATIENT", schema = "MEDICAL_RECORDS")
data class Patient(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_PATIENT", nullable = false, unique = true)
        val idPatient: Int,

        @NotBlank
        @Column(name = "NAME", length = 150)
        val name: String,

        @NotBlank
        @Column(name = "CPF", length = 11)
        val cpf: String,

        @NotBlank
        @Column(name = "GENDER")
        @Enumerated(EnumType.STRING)
        val gender: GenderTypes,

        @NotNull
        @Column(name = "BIRTHDATE", insertable = false, updatable = false)
        val birthDate: LocalDate,

        @Column(name = "BIRTHPLACE", length = 300)
        val birthPlace: String?,

        @Column(name = "FATHER_NAME", length = 150)
        val fatherName: String?,

        @Column(name = "MOTHER_NAME", length = 150)
        val motherName: String?,

        @OneToMany(mappedBy = "patient")
        val patientVaccines: List<PatientVaccines>? = null,

        @OneToMany(mappedBy = "patient")
        val medicalRecord: List<MedicalRecord>? = null,

        @OneToMany(mappedBy = "patient")
        val healthInsurance: List<HealthInsurance>? = null,

        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "ID_PATIENT")
        val lifeHistoric: List<LifeHistoric>? = null

) {

    @OneToOne
    @JoinColumn(name = "ID_USER")
    lateinit var user: User


}
package com.integrated.medical.records.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.integrated.medical.records.domain.dto.PatientDTO
import com.integrated.medical.records.enums.GenderTypes
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
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
        @Column(name = "BIRTHDATE")
//        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy::MM::dd")
        val birthDate: LocalDate,

        @OneToOne
        @JoinColumn(name = "ID_USER")
        val user: User
) {

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "FK_PATIENT")
    var patientVaccines: MutableList<PatientVaccines>? = mutableListOf()

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "FK_PATIENT")
    var medicalRecord: MutableList<MedicalRecord>? = mutableListOf()

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "FK_PATIENT")
    var patientHistoric: MutableList<PatientHistoric>? = mutableListOf()

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "FK_PATIENT")
    var emergencyCard: MutableList<EmergencyCard>? = mutableListOf()

}


fun List<Patient>.toDTO(): List<PatientDTO> {
    return map { it.toDTO() }
}

fun Patient.toDTO(): PatientDTO {
    var patientDTO = PatientDTO(
            this.idPatient,
            this.name,
            this.cpf,
            this.gender,
            this.birthDate,
            this.user.toDTO()
    )
    this.patientVaccines?.let {
        patientDTO.patientVaccines = PatientVaccines.entityListToDtoList(it)
    }

    this.medicalRecord?.let {
        patientDTO.medicalRecord = MedicalRecord.entityListToDtoList(it)
    }

    this.patientHistoric?.let {
        patientDTO.patientHistoric = PatientHistoric.entityListToDtoList(it)
    }

    this.emergencyCard?.let {
        patientDTO.emergencyCard = EmergencyCard.entityListToDtoList(it)
    }

    return patientDTO
}
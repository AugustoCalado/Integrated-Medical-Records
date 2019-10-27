package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.Patient
import com.integrated.medical.records.enums.GenderTypes
import java.io.Serializable
import java.time.LocalDate

class PatientDTO(

        var idPatient: Int,

        var name: String,

        var cpf: String,

        var gender: GenderTypes,

        var birthDate: LocalDate,

        var user: UserDTO

) : Serializable {
    var patientVaccines: MutableList<PatientVaccinesDTO>? = mutableListOf()
    var medicalRecord: MutableList<MedicalRecordDTO>? = mutableListOf()
    var patientHistoric: MutableList<PatientHistoricDTO>? = mutableListOf()
    var emergencyCard: MutableList<EmergencyCardDTO>? = mutableListOf()
}

fun List<PatientDTO>.toDTO(): List<Patient> {
    return map { it.toEntity() }
}

fun PatientDTO.toEntity(): Patient {
    var patient = Patient(
            this.idPatient,
            this.name,
            this.cpf,
            this.gender,
            this.birthDate,
            this.user.toEntity()
    )

    this.patientVaccines?.let {
        patient.patientVaccines = PatientVaccinesDTO.dtoListToEntityList(it)
    }

    this.medicalRecord?.let {
        patient.medicalRecord = MedicalRecordDTO.dtoListToEntityList(it)
    }

    this.patientHistoric?.let {
        patient.patientHistoric = PatientHistoricDTO.dtoListToEntityList(it)
    }

    this.emergencyCard?.let {
        patient.emergencyCard = EmergencyCardDTO.dtoListToEntityList(it)
    }

    return patient
}
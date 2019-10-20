package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.PatientVaccines
import java.io.Serializable
import java.time.LocalDate
import kotlin.streams.toList


data class PatientVaccinesDTO(

        var idPatientVaccines: Int,

        var vaccine: VaccinesDTO,

        var patient: PatientDTO,

        var dataVaccine: LocalDate,

        var placeVaccineApplied: String?
) : Serializable {

    companion object {
        fun dtoListToEntityList(dtoList: MutableList<PatientVaccinesDTO>): MutableList<PatientVaccines> {
            return dtoList.stream()
                    .map { it.toEntity() }
                    .toList()
                    .toMutableList()
        }
    }
}

fun PatientVaccinesDTO.toEntity(): PatientVaccines {
    var patientVaccines = PatientVaccines(
            this.idPatientVaccines,
            this.vaccine.toEntity(),
            this.patient.toEntity(),
            this.dataVaccine,
            this.placeVaccineApplied.orEmpty()
    )
    return patientVaccines
}
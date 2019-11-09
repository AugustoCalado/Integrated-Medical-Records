package com.integrated.medical.records.domain.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.integrated.medical.records.domain.PatientVaccines
import java.io.Serializable
import java.time.LocalDate
import kotlin.streams.toList


class PatientVaccinesDTO(

        var idPatientVaccines: Int,

        var vaccine: VaccinesDTO,

        var vaccineLot:String,

        @JsonFormat(pattern = "yyyy::MM::dd")
        var vaccineExpirationDate:LocalDate,

        @JsonFormat(pattern = "yyyy::MM::dd")
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
            this.vaccineLot,
            this.vaccineExpirationDate,
            this.dataVaccine,
            this.placeVaccineApplied.orEmpty()
    )
    return patientVaccines
}
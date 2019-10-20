package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.PatientHistoric
import com.integrated.medical.records.enums.TypeHistoric
import kotlin.streams.toList

class PatientHistoricDTO(

        val idPathologyHistoric: Int,

        val description: String,

        val extraObservation: String?,

        val typeHistoric: TypeHistoric
) {
    companion object {
        fun dtoListToEntityList(dtoList: MutableList<PatientHistoricDTO>): MutableList<PatientHistoric> {
            return dtoList.stream()
                    .map { it.toEntity() }
                    .toList()
                    .toMutableList()
        }
    }
}

fun PatientHistoricDTO.toEntity(): PatientHistoric {
    var patientHistoric = PatientHistoric(
            this.idPathologyHistoric,
            this.description,
            this.extraObservation,
            this.typeHistoric
    )
    return patientHistoric
}
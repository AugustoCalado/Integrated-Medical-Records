package com.integrated.medical.records.domain.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.integrated.medical.records.domain.MedicalExam
import java.io.Serializable
import java.time.LocalDate
import kotlin.streams.toList

class MedicalExamDTO (

        val idMedicalExam: Int,

        val examName: String,

        val examObservation: String,

        @JsonFormat(pattern = "yyyy::MM::dd")
        val prescriptionDate: LocalDate

) : Serializable {

    companion object {
        fun dtoListToEntityList(dtoList: MutableList<MedicalExamDTO>): MutableList<MedicalExam> {
            return dtoList.stream()
                    .map { it.toEntity() }
                    .toList()
                    .toMutableList()
        }
    }
}

fun MedicalExamDTO.toEntity(): MedicalExam {
    var medicalExam = MedicalExam(
            this.idMedicalExam,
            this.examName,
            this.examObservation.orEmpty(),
            this.prescriptionDate
    )
    return medicalExam
}
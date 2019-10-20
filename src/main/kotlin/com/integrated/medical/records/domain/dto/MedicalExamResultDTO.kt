package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.MedicalExam
import com.integrated.medical.records.domain.MedicalExamResult
import java.io.Serializable
import java.time.LocalDate
import kotlin.streams.toList

class MedicalExamResultDTO (

        val idMedicalExamResult: Int,

        val resultObservation: String?,

        val resultGenerationData: LocalDate,

        val medicalExam: MedicalExamDTO

) : Serializable

fun MedicalExamResultDTO.toEntity(): MedicalExamResult {
    var medicalExamResult = MedicalExamResult(
            this.idMedicalExamResult,
            this.resultObservation,
            this.resultGenerationData
    )

    medicalExamResult.medicalExam = this.medicalExam.toEntity()
    return medicalExamResult
}
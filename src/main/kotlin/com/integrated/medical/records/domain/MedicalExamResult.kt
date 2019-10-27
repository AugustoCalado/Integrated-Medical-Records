package com.integrated.medical.records.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.integrated.medical.records.domain.dto.MedicalExamResultDTO
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "MEDICAL_EXAM_RESULT", schema = "MEDICAL_RECORDS")
data class MedicalExamResult(

        @Id
        val idMedicalExamResult: Int,

        @Column(name = "EXAM_OBSERVATION", length = 500)
        val resultObservation: String?,

        @Column(name = "RESULT_GENERATION_DATA")
        @NotNull
        @JsonFormat(pattern = "yyyy::MM::dd")
        val resultGenerationData: LocalDate

) {
    @OneToOne
    @MapsId
    lateinit var medicalExam: MedicalExam
}

fun MedicalExamResult.toDTO(): MedicalExamResultDTO {
    var patientHistoricDTO = MedicalExamResultDTO(
            this.idMedicalExamResult,
            this.resultObservation,
            this.resultGenerationData,
            this.medicalExam.toDTO()
    )
    return patientHistoricDTO
}
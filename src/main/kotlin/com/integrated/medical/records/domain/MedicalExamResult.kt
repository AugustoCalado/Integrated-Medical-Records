package com.integrated.medical.records.domain

import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "MEDICAL_EXAM_RESULT", schema = "MEDICAL_RECORDS")
data class MedicalExamResult(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_MEDICAL_EXAM_RESULT", nullable = false, unique = true)
        val idMedicalExam: Int,

        @Column(name = "EXAM_OBSERVATION", length = 500)
        val resultObservation: String,

        @Column(name = "RESULT_GENERATION_DATA")
        @NotNull
        val resultGenerationData: LocalDate

        //TODO create new field with information about where and who perform the exam
) {
    @OneToOne
    @JoinColumn(name = "ID_MEDICAL_EXAM")
    lateinit var medicalExam: MedicalExam
}
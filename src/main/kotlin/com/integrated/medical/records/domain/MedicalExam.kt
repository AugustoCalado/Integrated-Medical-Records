package com.integrated.medical.records.domain

import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "MEDICAL_EXAM", schema = "MEDICAL_RECORDS")
data class MedicalExam(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_MEDICAL_EXAM", nullable = false, unique = true)
        val idMedicalExam: Int,

        @Column(name = "EXAM_NAME", length = 500)
        @NotNull
        val examName: String,

        @Column(name = "EXAM_OBSERVATION", length = 750)
        val examObservation: String?,

        @Column(name = "PRESCRIPTION_DATE")
        @NotNull
        val prescriptionDate: LocalDate


) {
    @ManyToOne
    @JoinColumn(name = "ID_MEDICAL_RECORD")
    lateinit var medicalRecord: MedicalRecord

}
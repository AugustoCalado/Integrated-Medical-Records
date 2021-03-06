package com.integrated.medical.records.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.integrated.medical.records.domain.dto.MedicalRecordDTO
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull
import kotlin.streams.toList


@Entity
@Table(name = "MEDICAL_RECORD", schema = "MEDICAL_RECORDS")
data class MedicalRecord(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_MEDICAL_RECORD", nullable = false, unique = true)
        val idMedicalRecord: Int,

        @Column(name = "DOCTOR_CRM", length = 20)
        @NotNull
        val crm: String,

        @Column(name = "MAIN_COMPLAIN", length = 750)
        @NotNull
        val mainComplain: String,

        @Column(name = "CURRENT_DISEASE_INFORMATION", length = 750)
        @NotNull
        val currentDiseaseInfo: String,

        @Column(name = "DIAGNOSTIC", length = 2050)
        @NotNull
        val diagnostic: String,

        @Column(name = "PRESCRIPTION", length = 2050)
        @NotNull
        val prescription: String,

        @Column(name = "MEDICAL_RECORD_DATE")
        @NotNull
        @JsonFormat(pattern = "yyyy::MM::dd")
        val medicalRecordDate: LocalDate,

        @Column(name = "MEDICAL_RECORD_PLACE")
        @NotNull
        val medicalRecordPlace: String


) {


    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "FK_PHYSICAL_EXAM")
    var physicalExam: MutableList<PhysicalExam> = mutableListOf()

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "FK_MEDICAL_RECORD")
    var medicalExam: MutableList<MedicalExam>? = mutableListOf()


    companion object {
        fun entityListToDtoList(dtoList: MutableList<MedicalRecord>): MutableList<MedicalRecordDTO> {
            return dtoList.stream()
                    .map { it.toDTO() }
                    .toList()
                    .toMutableList()
        }
    }

}

fun MedicalRecord.toDTO(): MedicalRecordDTO {
    var medicalRecordDTO = MedicalRecordDTO(
            this.idMedicalRecord,
            this.crm,
            this.mainComplain,
            this.currentDiseaseInfo,
            this.diagnostic,
            this.prescription,
            this.medicalRecordDate,
            this.medicalRecordPlace
    )

    this.medicalExam?.let {
        medicalRecordDTO.medicalExam = MedicalExam.entityListToDtoList(it)

    }

    this.physicalExam?.let {
        medicalRecordDTO.physicalExam = this.physicalExam.toDTO().toMutableList()
    }

    return medicalRecordDTO
}
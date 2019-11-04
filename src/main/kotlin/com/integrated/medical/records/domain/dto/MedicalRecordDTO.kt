package com.integrated.medical.records.domain.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.integrated.medical.records.domain.MedicalRecord
import java.time.LocalDate
import kotlin.streams.toList

class MedicalRecordDTO(

        val idMedicalRecord: Int,

        val crm: String,

        val mainComplain: String,

        val currentDiseaseInfo: String,

        val diagnostic: String,

        val prescription: String,

        @JsonFormat(pattern = "yyyy::MM::dd")
        val medicalRecordDate: LocalDate,

        val medicalRecordPlace: String

) {

    var medicalExam: MutableList<MedicalExamDTO>? = mutableListOf()
    var physicalExam: MutableList<PhysicalExamDTO> = mutableListOf()

    companion object {
        fun dtoListToEntityList(dtoList: MutableList<MedicalRecordDTO>): MutableList<MedicalRecord> {
            return dtoList.stream()
                    .map { it.toEntity() }
                    .toList()
                    .toMutableList()
        }
    }

}

fun MedicalRecordDTO.toEntity(): MedicalRecord {
    var medicalRecord = MedicalRecord(
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
        medicalRecord.medicalExam = MedicalExamDTO.dtoListToEntityList(it)

    }

    this.physicalExam?.let {
        medicalRecord.physicalExam = this.physicalExam.toEntity().toMutableList()
    }

    return medicalRecord
}
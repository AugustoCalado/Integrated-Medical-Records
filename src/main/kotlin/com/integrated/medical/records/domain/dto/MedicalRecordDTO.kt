package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.MedicalRecord
import java.time.LocalDate
import kotlin.streams.toList

class MedicalRecordDTO(

        val idMedicalRecord: Int,

        val crm: String,

        val mainComplain: String,

        val currentDiseaseInfo: String,

        val peHeadNeck: String?,

        val peBreathingApparatus: String?,

        val peHeartSystem: String?,

        val peBodyMembers: String?,

        val peBonesJoints: String?,

        val peNeurological: String?,

        val diagnostic: String,

        val prescription: String,

        val medicalRecordDate: LocalDate,

        val medicalRecordPlace: String

) {

    var medicalExam: MutableList<MedicalExamDTO>? = mutableListOf()

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
            this.peHeadNeck.orEmpty(),
            this.peBreathingApparatus.orEmpty(),
            this.peHeartSystem.orEmpty(),
            this.peBodyMembers.orEmpty(),
            this.peBonesJoints.orEmpty(),
            this.peNeurological.orEmpty(),
            this.diagnostic,
            this.prescription,
            this.medicalRecordDate,
            this.medicalRecordPlace
    )

    this.medicalExam?.let {
        medicalRecord.medicalExam = MedicalExamDTO.dtoListToEntityList(it)

    }

    return medicalRecord
}
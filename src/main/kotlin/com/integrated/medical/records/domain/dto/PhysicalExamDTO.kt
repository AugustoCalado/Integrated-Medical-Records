package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.PhysicalExam

data class PhysicalExamDTO(

        val idPhysicalExam: Int,

        val namePhysicalExam: String,

        val value: String

)

fun List<PhysicalExamDTO>.toEntity(): List<PhysicalExam> {
    return map { it.toEntity() }
}

fun PhysicalExamDTO.toEntity(): PhysicalExam {
    var physicalExam = PhysicalExam(
            this.idPhysicalExam,
            this.namePhysicalExam,
            this.value
    )
    return physicalExam
}
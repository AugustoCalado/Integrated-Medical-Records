package com.integrated.medical.records.domain

import com.integrated.medical.records.domain.dto.PhysicalExamDTO
import com.integrated.medical.records.domain.dto.VaccinesDTO
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "PHYSICAL_EXAM", schema = "MEDICAL_RECORDS")
data class PhysicalExam(

        @Id
        val idPhysicalExam: Int,

        @Column(name = "NAME_PHYSICAL_EXAM", length = 500)
        @NotNull
        val namePhysicalExam: String,

        @Column(name = "VALUE")
        @NotNull
        val value: String

)


fun List<PhysicalExam>.toDTO(): List<PhysicalExamDTO>{
    return map { it.toDTO() }
}

fun PhysicalExam.toDTO(): PhysicalExamDTO {
    var physicalExamDTO = PhysicalExamDTO(
            this.idPhysicalExam,
            this.namePhysicalExam,
            this.value
    )
    return physicalExamDTO
}
package com.integrated.medical.records.domain

import com.integrated.medical.records.domain.dto.PatientHistoricDTO
import com.integrated.medical.records.enums.TypeHistoric
import javax.persistence.*
import javax.validation.constraints.NotBlank
import kotlin.streams.toList


@Entity
@Table(name = "PATIENT_HISTORIC", schema = "MEDICAL_RECORDS")
data class PatientHistoric(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_PATHOLOGY_HISTORIC", nullable = false, unique = true)
        val idPathologyHistoric: Int,

        @NotBlank
        @Column(name = "DESCRIPTION", length = 500)
        val description: String,

        @Column(name = "EXTRA_OBSERVATION", length = 500)
        val extraObservation: String?,

        @NotBlank
        @Column(name = "TYPE_HISTORIC")
        @Enumerated(EnumType.STRING)
        val typeHistoric: TypeHistoric
) {

    companion object {
        fun entityListToDtoList(dtoList: MutableList<PatientHistoric>): MutableList<PatientHistoricDTO> {
            return dtoList.stream()
                    .map { it.toDTO() }
                    .toList()
                    .toMutableList()
        }
    }
}

fun PatientHistoric.toDTO(): PatientHistoricDTO {
    var patientHistoricDTO = PatientHistoricDTO(
            this.idPathologyHistoric,
            this.description,
            this.extraObservation,
            this.typeHistoric
    )
    return patientHistoricDTO
}
package com.integrated.medical.records.domain

import com.integrated.medical.records.domain.dto.EmergencyCardDTO
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import kotlin.streams.toList

data class EmergencyCard(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_EMERGENCY_CARD", nullable = false, unique = true)
        val idEmergencyCardDTO: Long,

        @NotBlank
        @Column(name = "DECLARATION", length = 500)
        val declaration: String,

        @NotBlank
        @Column(name = "OBSERVATIONS", length = 500)
        val observations: String

) {

    companion object {
        fun entityListToDtoList(dtoList: MutableList<EmergencyCard>): MutableList<EmergencyCardDTO> {
            return dtoList.stream()
                    .map { it.toDTO() }
                    .toList()
                    .toMutableList()
        }
    }
}

fun EmergencyCard.toDTO(): EmergencyCardDTO {
    var emergencyCardDTO  = EmergencyCardDTO(
            this.idEmergencyCardDTO,
            this.declaration,
            this.observations
    )
    return emergencyCardDTO
}
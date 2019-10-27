package com.integrated.medical.records.domain

import com.integrated.medical.records.domain.dto.EmergencyCardDTO
import javax.persistence.*
import javax.validation.constraints.NotBlank
import kotlin.streams.toList

@Entity
@Table(name = "EMERGENCY_CARD", schema = "MEDICAL_RECORDS")
data class EmergencyCard(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_EMERGENCY_CARD", nullable = false, unique = true)
        val idEmergencyCardDTO: Int,

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
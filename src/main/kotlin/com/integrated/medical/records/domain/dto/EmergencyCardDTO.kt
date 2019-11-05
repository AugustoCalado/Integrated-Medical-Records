package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.EmergencyCard
import com.integrated.medical.records.enums.EmergencyCardType

import kotlin.streams.toList

class EmergencyCardDTO(

        val idEmergencyCardDTO: Int,

        val declaration: String,

        val observations: String,

        val emergencyCardType: EmergencyCardType

) {

    companion object {
        fun dtoListToEntityList(dtoList: MutableList<EmergencyCardDTO>): MutableList<EmergencyCard> {
            return dtoList.stream()
                    .map { it.toEntity() }
                    .toList()
                    .toMutableList()
        }
    }
}

fun EmergencyCardDTO.toEntity(): EmergencyCard {
    var emergencyCard = EmergencyCard(
            this.idEmergencyCardDTO,
            this.declaration,
            this.observations,
            this.emergencyCardType
    )
    return emergencyCard
}
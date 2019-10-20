package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.enums.TypeHistoric

class PatientHistoricDTO(

        val idPathologyHistoric: Int,

        val description: String,

        val extraObservation: String?,

        val typeHistoric: TypeHistoric
)
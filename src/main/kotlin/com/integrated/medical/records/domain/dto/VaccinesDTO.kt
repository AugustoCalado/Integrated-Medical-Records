package com.integrated.medical.records.domain.dto

data class VaccinesDTO(

        val idVaccine: Int,

        val name: String,

        val description: String,

        val nDoses: Int
) {
}
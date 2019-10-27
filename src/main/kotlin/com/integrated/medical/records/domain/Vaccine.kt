package com.integrated.medical.records.domain

import com.integrated.medical.records.domain.dto.VaccinesDTO
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "VACCINE", schema = "MEDICAL_RECORDS")
data class Vaccine(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_VACCINE", nullable = false, unique = true)
        val idVaccine: Int,

        @Column(name = "NAME")
        @NotBlank
        val name: String,

        @Column(name = "DESCRIPTION", length = 1000)
        val description: String?,

        @Column(name = "N_DOSES", length = 2)
        val numberDoses: Int?
)

fun Vaccine.toDTO(): VaccinesDTO {
    var vaccineDTO = VaccinesDTO(
            this.idVaccine,
            this.name,
            this.description.orEmpty(),
            this.numberDoses ?: 0
    )
    return vaccineDTO
}
package com.integrated.medical.records.domain

import com.integrated.medical.records.domain.dto.PatientVaccinesDTO
import com.integrated.medical.records.domain.dto.toEntity
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import kotlin.streams.toList


@Entity
@Table(name = "VACCINE_HAS_PATIENT", schema = "MEDICAL_RECORDS")
data class PatientVaccines(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "IDVACCINES_HAS_PATIENT", nullable = false, unique = true)
        val idPatientVaccines: Int,

        @ManyToOne
        @JoinColumn(name = "ID_VACCINE")
        @NotBlank
        val vaccine: Vaccine,

        @ManyToOne
        @JoinColumn(name = "ID_PATIENT")
        @NotBlank
        val patient: Patient,

        @Column(name = "DATA_IMMUNIZATION")
        @NotBlank
        val dataVaccine: LocalDate,

        @Column(name = "PLACE_VACCINE_APPLIED")
        val placeVaccineApplied: String? = null

) : Serializable {
    companion object {
        fun entityListToDtoList(dtoList: MutableList<PatientVaccines>): MutableList<PatientVaccinesDTO> {
            return dtoList.stream()
                    .map { it.toDTO() }
                    .toList()
                    .toMutableList()
        }
    }
}

fun PatientVaccines.toDTO(): PatientVaccinesDTO {
    var patientVaccinesDTO = PatientVaccinesDTO(
            this.idPatientVaccines,
            this.vaccine.toDTO(),
            this.patient.toDTO(),
            this.dataVaccine,
            this.placeVaccineApplied.orEmpty()
    )
    return patientVaccinesDTO
}
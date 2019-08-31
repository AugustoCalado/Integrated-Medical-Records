package com.integrated.medical.records.domain

import org.jetbrains.annotations.NotNull
import java.io.Serializable
import java.time.LocalDate
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty


@Entity
@Table(name = "VACCINES_has_PATIENTS", schema = "MEDICAL_RECORDS")
data class PatientVaccines(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idVACCINES_has_PATIENTScol", nullable = false, unique = true)
        val idPatientVaccines: Int,

        @ManyToOne
        @JoinColumn(name = "VACCINES_idVACCINES")
        @NotBlank
        val vaccines: Vaccines,

        @ManyToOne
        @JoinColumn(name = "PATIENTS_idPATIENTS")
        @NotBlank
        val patient: Patient,

        @Column(name = "DATA_IMMUNIZATION")
        @NotBlank
        val dataVaccine: LocalDate,

        @Column(name = "PLACE_VACCINE_APPLIED")
        val placeVaccineApplied: String


) : Serializable {

/*        @OneToMany(mappedBy = "patientVaccines")
        lateinit var patientVaccinesHasVaccines: List<PatientVaccinesHasVaccines>*/
}
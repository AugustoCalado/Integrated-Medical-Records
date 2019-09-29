package com.integrated.medical.records.domain

import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "VITAL_SIGNS", schema = "MEDICAL_RECORDS")
data class VitalSigns(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID_VITAL_SIGNS", nullable = false, unique = true)
        val idFamilyHistoric: Int,

        @Column(name = "SYSTOLIC_PRESSURE")
        @NotNull
        val systolicPressure: Int,

        @Column(name = "DIASTOLIC_PRESSURE")
        @NotNull
        val diastolicPressure: Int,

        @Column(name = "HEART_RATE")
        val heartRate: Int,
        //batidas por minuto (rpm)

        @Column(name = "RESPIRATORY_FREQUENCY")
        val respiratoryFrequency: Int,
        //respirações por minuto (rpm)

        @Column(name = "BLOOD_TEMPERATURE")
        @NotNull
        val bloodTemperature: Double,

        @Column(name = "BODY_MASS_INDEX")
        val bodyMassIndex: Double,

        @Column(name = "WEIGHT")
        @NotNull
        val weight: Double,

        @Column(name = "HEIGHT")
        @NotNull
        val height: Double,

        @Column(name = "MEASUREMENT_DATE")
        @NotNull
        val measurementDate: LocalDate


) {
        // TODO self-relationship

        @OneToOne
        @JoinColumn(name = "ID_MEDICAL_RECORD")
        lateinit var medicalRecord: MedicalRecord

}
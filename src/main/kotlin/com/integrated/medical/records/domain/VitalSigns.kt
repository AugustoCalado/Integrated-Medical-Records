package com.integrated.medical.records.domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "VITAL_SIGNS", schema = "MEDICAL_RECORDS")
data class VitalSigns(

        @Id
        val idVitalSigns: Int,

        @Column(name = "SYSTOLIC_PRESSURE")
        @NotNull
        val systolicPressure: Int,

        @Column(name = "DIASTOLIC_PRESSURE")
        @NotNull
        val diastolicPressure: Int,

        @Column(name = "HEART_RATE")
        val heartRate: Int?,
        //batidas por minuto (rpm)

        @Column(name = "RESPIRATORY_FREQUENCY")
        val respiratoryFrequency: Int?,
        //respirações por minuto (rpm)

        @Column(name = "BLOOD_TEMPERATURE")
        val bloodTemperature: Double?,

        @Column(name = "BODY_MASS_INDEX")
        val bodyMassIndex: Double?,

        @Column(name = "WEIGHT")
        val weight: Double?,

        @Column(name = "HEIGHT")
        val height: Double?,

        @Column(name = "MEASUREMENT_DATE")
        @NotNull
        @JsonFormat(pattern = "yyyy::MM::dd")
        val measurementDate: LocalDate


) {
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "ID_MEDICAL_RECORD")
    lateinit var medicalRecord: MedicalRecord

}
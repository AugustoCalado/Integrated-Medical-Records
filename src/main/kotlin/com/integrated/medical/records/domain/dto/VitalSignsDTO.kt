package com.integrated.medical.records.domain.dto

import java.io.Serializable
import java.time.LocalDate

class VitalSignsDTO(

        val idVitalSigns: Int,

        val systolicPressure: Int,

        val diastolicPressure: Int,

        val heartRate: Int,
        //batidas por minuto (rpm)

        val respiratoryFrequency: Int,
        //respirações por minuto (rpm)

        val bloodTemperature: Double,

        val bodyMassIndex: Double,

        val weight: Double,

        val height: Double,

        val measurementDate: LocalDate,

        val medicalRecord: MedicalRecordDTO
) : Serializable {

}

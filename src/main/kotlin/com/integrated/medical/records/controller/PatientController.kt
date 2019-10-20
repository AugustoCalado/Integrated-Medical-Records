package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.PatientDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.exception.PatientUpdateException
import com.integrated.medical.records.service.PatientService
import io.swagger.annotations.Api
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(value = "Patient Management System")
@RepositoryRestController
@RequestMapping(value = "/patient")
class PatientController(
        val patientService: PatientService
) {

    @GetMapping("/patient/get/{cpf}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPatient(@PathVariable(name = "cpf", required = true) cpf: String): ResponseEntity<PatientDTO> {
        return try {
            val patient = patientService.findPatientByCpf(cpf)
            ResponseEntity(patient, HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/patient/update-information/{cpf}")
    fun updatePatientInformation(
            @RequestBody(required = true) patient: PatientDTO,
            @PathVariable(name = "cpf", required = true) cpf: String
    ): ResponseEntity<String> {
        return try {
            patientService.updatePatient(patient, cpf)
            ResponseEntity(HttpStatus.OK)
        } catch (ex: PatientUpdateException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


}

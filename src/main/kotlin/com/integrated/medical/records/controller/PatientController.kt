package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.EmergencyCardDTO
import com.integrated.medical.records.domain.dto.PatientDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.exception.UpdateException
import com.integrated.medical.records.service.PatientService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
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

    @GetMapping("/get/{cpf}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPatient(@PathVariable(name = "cpf", required = true) cpf: String): ResponseEntity<PatientDTO> {
        return try {
            val patient = patientService.findPatientByCpf(cpf)
            ResponseEntity(patient, HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/insert")
    fun insertPatient(@RequestBody(required = true) patientDTO: PatientDTO): ResponseEntity<String> {
        return try {
            val patientResponse = patientService.addNewPatient(patientDTO)
            ResponseEntity(HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("/update-information/{cpf}")
    fun updatePatientInformation(
            @RequestBody(required = true) patientDTO: PatientDTO,
            @PathVariable(name = "cpf", required = true) cpf: String
    ): ResponseEntity<*> {
        return try {
            val patientUpdated = patientService.updatePatient(patientDTO, cpf)
            ResponseEntity(patientUpdated, HttpStatus.OK)
        } catch (ex: UpdateException) {
            ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @ApiOperation(value = " get all Patients",response = PatientDTO::class, responseContainer = "List")
    @GetMapping(value = "get-all-test")
    fun getAllPatientsFromDB(): ResponseEntity<*> {
        return ResponseEntity(patientService.getAllPatientsFromDB(), HttpStatus.OK)
    }
}

package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.PatientVaccinesDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.service.PatientImmunizationService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(value = "Immunization Patient Management System")
@RepositoryRestController
@RequestMapping(value = "/patient-immunization")
class PatientImmunizationController(
        val patientImmunizationService: PatientImmunizationService
) {

    //TODO Introduce some way to authorize and authenticate
    //TODO include Swagger

    @ApiOperation(value = "Get all vaccine of a patient given the ID")
    @GetMapping("/patient-immunization/all", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllPatientImmunizations(
            @RequestParam(name = "cpf", required = true) cpf: String
    ): ResponseEntity<List<PatientVaccinesDTO>> {
        val listOfImmunizations: List<PatientVaccinesDTO> = patientImmunizationService.findAllPatientImmunization(cpf)
        return ResponseEntity(listOfImmunizations, HttpStatus.OK)

    }

    @ApiOperation(value = "Get a specific vaccine of a patient")
    @GetMapping("/patient-immunization", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPatientImmunization(
            @RequestParam(name = "idPatient", required = true) idPatient: Int,
            @RequestParam(name = "idPatientVaccine", required = true) idPatientVaccines: Int
    ): ResponseEntity<*> {
        return try {
            val response = patientImmunizationService.findPatientImmunization(idPatient, idPatientVaccines)
            ResponseEntity(response, HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
        }
    }

    @ApiOperation(value = "Register the patient immunization")
    @PostMapping("/patient-immunization/add-immunization/{cpf}")
    fun addPatientImmunization(
            @RequestParam(name = "cpf", required = true) cpf: String,
            @RequestBody(required = true) vaccinesDTO: PatientVaccinesDTO
    ): ResponseEntity<String> {
        return try {
            patientImmunizationService.insertPatientImmunization(cpf, vaccinesDTO)
            ResponseEntity(HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
        }
    }

    @ApiOperation(value = "Delete patient vaccine")
    @DeleteMapping("/patient-immunization/delete}")
    fun deletePatientImmunization(
            @RequestParam(name = "cpfPatient", required = true) cpfPatient: String,
            @RequestParam(name = "idPatientVaccine", required = true) idPatientVaccines: Int

    ): ResponseEntity<String> {
        return try {
            patientImmunizationService.deletePattientImmunization(cpfPatient, idPatientVaccines)
            ResponseEntity(HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
        }
    }


}

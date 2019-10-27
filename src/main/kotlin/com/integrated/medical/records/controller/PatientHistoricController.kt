package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.PatientHistoricDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.exception.UpdateException
import com.integrated.medical.records.service.PatientService
import io.swagger.annotations.Api
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(value = "Patient Management System")
@RepositoryRestController
@RequestMapping(value = "/patient-historic")
class PatientHistoricController(
        val patientService: PatientService
) {

    @GetMapping("/get/{cpf}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPatientHistoric(@PathVariable(name = "cpf", required = true) cpf: String): ResponseEntity<List<PatientHistoricDTO>> {
        return try {
            val patientHistoric = patientService.getPatientHistorics(cpf)
            ResponseEntity(patientHistoric, HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/add-historic/{cpf}")
    fun addNewPatientHistoric(
            @RequestBody(required = true) patientHistoricDTO: PatientHistoricDTO,
            @PathVariable(name = "cpf", required = true) cpf: String
    ): ResponseEntity<String> {
        return try {
            patientService.addPatientHistoric(patientHistoricDTO, cpf)
            ResponseEntity(HttpStatus.OK)
        } catch (ex: UpdateException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}

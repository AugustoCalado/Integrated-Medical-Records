package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.PatientVaccinesDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.io.Serializable
import java.time.LocalDate

@Api(value = "Immunization Patient Management System")
@RestController
@RequestMapping("/patient-immunizations")
class PatientImmunizationController {

    //TODO Introduce some way to authorize and authenticate
    //TODO include Swagger

    @GetMapping("/test")
    fun testController(): ResponseEntity<String> {
        return ResponseEntity.ok("{Teste}")
    }


    @ApiOperation(value = "Get all vaccine of a patient given the ID")
    @GetMapping("/{idPatient}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllPatientImmunizations(
            @PathVariable(value = "idPatient", required = true) idPatient: Int
    ): ResponseEntity<List<PatientVaccinesDTO>> {

        var listOfImmunizations = ArrayList<PatientVaccinesDTO>()

        return ResponseEntity(
                listOfImmunizations,
                HttpStatus.OK
        )
    }

    @ApiOperation(value = "Get a specific vaccine of a patient")
    @GetMapping("/{idPatient}", produces = [MediaType.APPLICATION_JSON_VALUE], params = ["idPatientVaccine", "idPatient"])
    fun getPattientImmunization(
            @PathVariable(value = "idPatient", required = true) idPatient: Int,
            @RequestParam(name = "idPatientVaccine", required = true) idPatientVaccines: Int
    ): ResponseEntity<PatientVaccinesDTO> {

        return ResponseEntity(HttpStatus.OK)
    }

    @ApiOperation(value = "Register the patient immunization")
    @PostMapping(value = "/register")
    fun <T> registerPatientImmunization(@RequestBody register: Map<String, Serializable>): ResponseEntity<T> {

        return ResponseEntity(HttpStatus.OK)
    }

    @ApiOperation(value = "Register the patient immunization")
    @PostMapping(value = "/register", params = ["idPatient", "idVaccine", "data", "place"])
    fun <T> registerPatientImmunization(
            @RequestParam(name = "idPatient", required = true) idPatient: Int,
            @RequestParam(name = "idVaccine", required = true) idVaccine: Int,
            @RequestParam(name = "data", required = true) immunizationDate: LocalDate,
            @RequestParam(name = "place") placeImmunization: String
    ): ResponseEntity<T> {

    //This endpoint is going to receive parameters to registry one patient vaccination


        return ResponseEntity(HttpStatus.OK)
    }

    @ApiOperation(value = "Delete patient vaccine")
    @DeleteMapping(value = "/delete/}")
    fun <T> deletePatientVaccine(
            @PathVariable(value = "idPatient", required = true) idPatient: Int,
            @RequestParam(name = "idPatientVaccine", required = true) idPatientVaccines: Int

    ): ResponseEntity<T> {


        return ResponseEntity(HttpStatus.OK)
    }




}

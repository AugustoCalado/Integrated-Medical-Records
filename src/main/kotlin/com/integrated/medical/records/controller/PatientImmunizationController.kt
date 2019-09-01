package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.PatientVaccinesDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.Serializable
import java.time.LocalDate

@RestController(value = "/patient/immunization")
class PatientImmunizationController {

    //TODO Introduce some way to authorize and authenticate
    //TODO include Swagger


    @GetMapping("patient-immunizations")
    fun getAllPatientImmunizations(): ResponseEntity<List<PatientVaccinesDTO>> {
        var listOfImmunizations = ArrayList<PatientVaccinesDTO>()
        return ResponseEntity(
                listOfImmunizations,
                HttpStatus.OK
        )
    }

    @GetMapping("patient-immunization")
    fun getPattientImmunization(@RequestParam(name = "idPatientVaccines") idPatientVaccines: Int):
            ResponseEntity<PatientVaccinesDTO> {

        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping(value = "/register")
    fun <T> registerPatientImmunization(@RequestBody register: Map<String, Serializable>): ResponseEntity<T> {

        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping(value = "/registers")
    fun <T> registerPatientImmunization(@RequestParam(name = "idPatient", required = true) idPatient: Int,
                                        @RequestParam(name = "idVaccine", required = true) idVaccine: Int,
                                        @RequestParam(name = "data", required = true) immunizationDate: LocalDate,
                                        @RequestParam(name = "place") placeImmunization: String
    ): ResponseEntity<T> {

        /*This endpoint is going to receive parameters to registry one patient vaccination  */

        return ResponseEntity(HttpStatus.OK)
    }


}
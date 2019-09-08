package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.Patient
import com.integrated.medical.records.repository.PatientRepository
import io.swagger.annotations.Api
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@Api(value = "Immunization Patient Management System")
@RepositoryRestController
//@RequestMapping(path = ["/patient"])
class PatientController {

    lateinit var patientRepository: PatientRepository

    @GetMapping(path = ["/getYoungersPatients"])
    // ResponseEntity<Resource<PatientResource>>
    fun getPatientsByBirthDate(): ResponseEntity<List<Patient>> {
        val patients: List<Patient> = patientRepository.findAllByBirthDateNotNull()
        patients.forEach { p -> println(p) }
        return ResponseEntity(patients, HttpStatus.OK)

    }

}

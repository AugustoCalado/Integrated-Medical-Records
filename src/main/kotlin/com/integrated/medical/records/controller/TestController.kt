package com.integrated.medical.records.controller

import com.integrated.medical.records.service.PatientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController(value = "/test")

class TestController {

    @Autowired
    lateinit var patientService: PatientService

    @GetMapping
    fun printPatients(){
        patientService.getAllPatients()
    }
}
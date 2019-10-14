package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.HealthInsuranceDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.service.HealthInsuranceService
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RepositoryRestController
@RequestMapping(value="/health-insurance")
class HealthInsuranceController(val healthInsuranceService: HealthInsuranceService) {

    @PostMapping(path = ["add-new-insurance"])
    fun addNewHealthInsurance(
            @RequestBody @Valid healthInsuranceDTO: HealthInsuranceDTO,
            @RequestParam(value = "cpf", required = true) cpf: String
    ): ResponseEntity<String> {
        healthInsuranceService.insertNewHealthInsurance(cpf, healthInsuranceDTO)
        return ResponseEntity(HttpStatus.OK)
    }

    @PutMapping(path = ["update-health-insurance"])
    fun updateHealthInsurance(@RequestBody @Valid healthInsuranceDTO: HealthInsuranceDTO): ResponseEntity<String> {
        try {
            healthInsuranceService.updateHealthInsurance(healthInsuranceDTO.idHealthInsurance, healthInsuranceDTO)
        } catch (ex: Exception) {
            return when (ex) {
                is ObjectNotFoundException -> {
                    ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
                }
                else -> ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping(path = ["delete-health-insurance"])
    fun deleteHealthInsurance(@RequestParam(value = "idHealthInsurance") idHealthInsurance: Int): ResponseEntity<String> {
        try {
            healthInsuranceService.deleteHealthInsurance(idHealthInsurance)
        } catch (ex: Exception) {
            return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(HttpStatus.OK)
    }


}
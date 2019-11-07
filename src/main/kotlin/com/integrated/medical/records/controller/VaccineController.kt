package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.UserDTO
import com.integrated.medical.records.domain.dto.VaccinesDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.service.VaccineService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(value = "Vaccines Controller API")
@RepositoryRestController
@RequestMapping(value = "/vaccine")
class VaccineController(val vaccineService: VaccineService) {

    @ApiOperation(value = "get all vaccines", response = VaccinesDTO::class, responseContainer = "List")
    @GetMapping("/get/all")
    fun getAllVaccines(): ResponseEntity<List<VaccinesDTO>> {

        val response = vaccineService.getAllVaccines() ?: emptyList()
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("get/{idVaccine}")
    fun getVaccine(@PathVariable(required = true) idVaccine: Int): ResponseEntity<*> {
        return try {
            return ResponseEntity(vaccineService.getVaccine(idVaccine), HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping
    fun registerVaccine(@RequestBody(required = true) vaccine: VaccinesDTO): ResponseEntity<String> {
        vaccineService.addVaccine(vaccine)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping
    fun deleteVaccine(@RequestBody(required = true) vaccine: VaccinesDTO): ResponseEntity<String> {
        return try {
            vaccineService.deleteVaccine(vaccine)
            ResponseEntity(HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
        }
    }

}

package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.VaccinesDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController(value = "/vaccines")
class VaccineController {

    @GetMapping("/get/all")
    fun getAllVaccines(): ResponseEntity<List<VaccinesDTO>> {
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("get/{idVaccine}")
    fun getVaccine(@PathVariable(required = true) idVaccine: Int): ResponseEntity<VaccinesDTO> {
        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    fun registerVaccine(@RequestBody(required = true) vaccine: VaccinesDTO): ResponseEntity<String> {
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping
    fun deleteVaccine(@RequestBody(required = true) vaccine: VaccinesDTO): ResponseEntity<String> {
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping
    fun deleteVaccine(@RequestParam(name = "idVaccine", required = true) idVaccine: Int): ResponseEntity<String> {
        return ResponseEntity(HttpStatus.OK)
    }

}
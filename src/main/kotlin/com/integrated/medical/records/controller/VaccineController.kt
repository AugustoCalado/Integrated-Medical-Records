package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.VaccinesDTO
import com.integrated.medical.records.repository.VaccineRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/vaccine"])
class VaccineController {

    @Autowired
    lateinit var vaccineRepository: VaccineRepository

    @Autowired
    lateinit var modelMapper: ModelMapper

    @GetMapping("/get/all")
    fun getAllVaccines(): ResponseEntity<List<VaccinesDTO>> {
        var vaccineList = vaccineRepository.findAll().toList()
        var returnVaccines = mutableListOf<VaccinesDTO>()
        vaccineList.forEach { x ->
            var y: VaccinesDTO = modelMapper.map(x, VaccinesDTO::class.java)
            returnVaccines.add(y)
        }
        return ResponseEntity(returnVaccines, HttpStatus.OK)
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

    @DeleteMapping(params = ["idVaccine"])
    fun deleteVaccine(@RequestParam(name = "idVaccine", required = true) idVaccine: Int): ResponseEntity<String> {
        return ResponseEntity(HttpStatus.OK)
    }

}

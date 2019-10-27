package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.MedicalRecordDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.service.MedicalRecordService
import io.swagger.annotations.Api
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RepositoryRestController
@Api(value = "Medical Record Controller API")
@RequestMapping(value = "/medical-record")
class MedicalRecordController(val medicalRecordService: MedicalRecordService) {

    @GetMapping(value = "/get-all-records")
    fun getAllMedicalRecordsOfPatient(@RequestParam(value = "patientCPF") patientCPF: String): ResponseEntity<*> {

        return try {
            val listOfMedicalRecords = medicalRecordService.getAllMedicalRecords(patientCPF)
            ResponseEntity(listOfMedicalRecords, HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping(value = "/get-record")
    fun getEmergencyCardItem(@RequestParam(value = "idMedicalRecord") idMedicalRecord: Int): ResponseEntity<*> {

        return try {
            val medicalRecordResponse = medicalRecordService.getMedicalRecord(idMedicalRecord)
            ResponseEntity(medicalRecordResponse, HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping(value = "/save")
    fun saveNewMedicalRecord(
            @RequestParam(value = "cpf") patientCPF: String,
            @RequestBody medicalRecordDTO: MedicalRecordDTO
    ): ResponseEntity<*> {

        return try {
            val medicalRecordResponse = medicalRecordService.insertMedicalRecord(patientCPF, medicalRecordDTO)
            ResponseEntity(medicalRecordResponse, HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("/medical-record/save")
    fun saveMedicalRecord(@RequestBody medicalRecord: MedicalRecordDTO): ResponseEntity<String> {
        return ResponseEntity(HttpStatus.ACCEPTED)
    }

    @DeleteMapping
    fun deleteVaccine(@RequestParam(required = true) idMedicalRecord: Int): ResponseEntity<String> {

        return try {
            medicalRecordService.deleteMedicalRecord(idMedicalRecord)
            ResponseEntity(HttpStatus.OK)
        } catch (ex: ObjectNotFoundException) {
            ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
        }
    }

}
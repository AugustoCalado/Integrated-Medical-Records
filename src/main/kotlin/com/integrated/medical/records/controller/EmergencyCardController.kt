package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.EmergencyCardDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.service.EmergencyCardService
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RepositoryRestController
@RequestMapping(value = "/emergency-card")
class EmergencyCardController(val emergencyCardService: EmergencyCardService) {


    @GetMapping(value = "/get-cards")
    fun getEmergencyCardsOfPatient(@RequestParam(value = "cpf") patientCPF: String): ResponseEntity<*> {

        return try {
            val listOfEmergencyCard = emergencyCardService.getEmergencyCardItens(patientCPF)
            ResponseEntity(listOfEmergencyCard, HttpStatus.OK)
        } catch (ex: Exception) {
            return when (ex) {
                is ObjectNotFoundException -> {
                    ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
                }
                else -> ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }

    @PostMapping(value = "/save")
    fun saveNewItemEmergencyCard(
            @RequestParam(value = "cpf") patientCPF: String,
            @RequestBody emergencyCardItem: EmergencyCardDTO
    ): ResponseEntity<*> {

        return try {
            val patientResponse = emergencyCardService.insertEmergencyCardItem(patientCPF, emergencyCardItem)
            ResponseEntity(patientResponse, HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping(path = ["update"])
    fun updateEmergencyCard(@RequestBody emergencyCardItemDTO: EmergencyCardDTO): ResponseEntity<*> {

        return try {
            val emergencyCardResponse = emergencyCardService.updateEmergencyCardItem(emergencyCardItemDTO)
            ResponseEntity(emergencyCardResponse, HttpStatus.OK)
        } catch (ex: Exception) {
            return when (ex) {
                is ObjectNotFoundException -> {
                    ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
                }
                else -> ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }

    }
}

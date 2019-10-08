package com.integrated.medical.records.controller

import com.integrated.medical.records.domain.dto.MedicalRecordDTO
import com.integrated.medical.records.repository.MedicalRecordRepository
import com.integrated.medical.records.repository.PatientRepository
import io.swagger.annotations.Api
import org.modelmapper.ModelMapper
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@RepositoryRestController
@Api(value = "Medical Record Controller API")
class MedicalRecordController(
        val modelMapper: ModelMapper,

        val medicalRecordRepository: MedicalRecordRepository,

        val patientRepository: PatientRepository
) {

    @PostMapping("/medical-record/save")
    fun saveMedicalRecord(@RequestBody medicalRecord: MedicalRecordDTO): ResponseEntity<String> {
        return ResponseEntity(HttpStatus.ACCEPTED)
    }

/*    @GetMapping(path = ["/medical-record/get-all"])
    fun getMedicalRecordByCPF(@RequestParam(name = "cpf") cpf: String): ResponseEntity<List<MedicalRecordDTO>> {
        //TODO How to implement pagination
        var patient = patientRepository.findByCpf(cpf)
        var listOfMedicalRecord = medicalRecordRepository.findByPatient(patient)

        listOfMedicalRecord.stream().map(modelMapper.map(it,MedicalRecordDTO::class.java))

        listOfMedicalRecord.forEach {
            record -> modelMapper.map(record, MedicalRecordDTO::class.java)
            listOfMedicalRecord.
        }

        *//*
        * x ->
            var y: VaccinesDTO = modelMapper.map(x, VaccinesDTO::class.java)
        * *//*
    }*/

}
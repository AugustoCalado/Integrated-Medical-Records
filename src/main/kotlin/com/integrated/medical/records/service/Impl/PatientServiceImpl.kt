package com.integrated.medical.records.service.Impl

import com.integrated.medical.records.domain.dto.PatientDTO
import com.integrated.medical.records.repository.PatientRepository
import com.integrated.medical.records.service.PatientService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PatientServiceImpl(val patientRepo: PatientRepository) : PatientService {

    @Autowired
    lateinit var modelMapper: ModelMapper

    override fun getAllPatients(): List<PatientDTO>? {
        var listOfPatients = patientRepo.findAll()
        listOfPatients.forEach { println(it) }
        return null

    }

    override fun getPatientWithName(name: String): List<PatientDTO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
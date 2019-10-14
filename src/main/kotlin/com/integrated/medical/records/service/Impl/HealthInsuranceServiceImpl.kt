package com.integrated.medical.records.service.Impl

import com.integrated.medical.records.domain.HealthInsurance
import com.integrated.medical.records.domain.dto.HealthInsuranceDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.repository.HealthInsuranceRepository
import com.integrated.medical.records.repository.PatientRepository
import com.integrated.medical.records.service.HealthInsuranceService
import org.modelmapper.ModelMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class HealthInsuranceServiceImpl(
        val patientRepository: PatientRepository,
        val healthInsuranceRepository: HealthInsuranceRepository,
        val modelMapper: ModelMapper
) : HealthInsuranceService {

    @Throws(ObjectNotFoundException::class)
    override fun insertNewHealthInsurance(cpf: String, healthInsuranceDTO: HealthInsuranceDTO) {

        val patient = patientRepository.findByCpf(cpf)
                ?: throw ObjectNotFoundException("Patient: ${cpf} not found \n Health Insurance was not inserted")

        //TODO Maybe we are going to have problems with the convertion of the DTO -> DAO objects inside the class
        val healthInsurance = modelMapper.map(healthInsuranceDTO, HealthInsurance::class.java)

        healthInsurance.patient = patient

        healthInsuranceRepository.save(healthInsurance)

    }

    @Throws(ObjectNotFoundException::class, IllegalArgumentException::class)
    override fun updateHealthInsurance(idHealthInsurance: Int, healthInsuranceDTO: HealthInsuranceDTO) {

        healthInsuranceRepository.findByIdOrNull(idHealthInsurance)
                ?: throw ObjectNotFoundException("Health Insurance Id: ${idHealthInsurance} was not found \n Updated was not performed")

        //TODO Maybe we are going to have problems with the convertion of the DTO -> DAO objects inside the class
        val updatedHealthInsurance = modelMapper.map(healthInsuranceDTO, HealthInsurance::class.java)
        healthInsuranceRepository.save(updatedHealthInsurance)

        //healthInsuranceRepository.save(generateUpdatedHealthInsurance(healthInsuranceDTO, healthInsurance))
    }

    @Throws(Exception::class)
    override fun deleteHealthInsurance(idHealthInsurance: Int) {
        healthInsuranceRepository.deleteById(idHealthInsurance)
    }

    private fun generateUpdatedHealthInsurance(
            healthInsuranceDTO: HealthInsuranceDTO,
            healthInsurance: HealthInsurance): HealthInsurance {
        var updatedHealthInsurance = HealthInsurance(
                healthInsurance.idHealthInsurance,
                healthInsuranceDTO.healthInsuranceCompany,
                healthInsuranceDTO.healthInsuranceName,
                healthInsuranceDTO.insuranceCardNumber,
                healthInsuranceDTO.cardExpirationDate
        )
        updatedHealthInsurance.patient = healthInsurance.patient
        return updatedHealthInsurance
    }

}
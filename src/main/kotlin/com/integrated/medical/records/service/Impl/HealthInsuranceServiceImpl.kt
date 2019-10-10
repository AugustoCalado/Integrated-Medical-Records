package com.integrated.medical.records.service.Impl

import com.integrated.medical.records.domain.HealthInsurance
import com.integrated.medical.records.domain.dto.HealthInsuranceDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.repository.HealthInsuranceRepository
import com.integrated.medical.records.repository.PatientRepository
import com.integrated.medical.records.service.HealthInsuranceService
import org.modelmapper.ModelMapper
import org.springframework.data.repository.findByIdOrNull

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

        val healthInsurance = healthInsuranceRepository.findByIdOrNull(idHealthInsurance)
                ?: throw ObjectNotFoundException("Health Insurance Id: ${idHealthInsurance} was not found \n Updated was not performed")
        val updatedHealthInsurance = modelMapper.map(healthInsuranceDTO, HealthInsurance::class.java)

        healthInsuranceRepository.save(generateUpdatedHealthInsurance(healthInsuranceDTO, healthInsurance))
    }

    override fun deleteHealthInsurance(idHealthInsurance: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
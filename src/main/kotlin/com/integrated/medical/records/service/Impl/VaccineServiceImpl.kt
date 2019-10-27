package com.integrated.medical.records.service.Impl

import com.integrated.medical.records.domain.dto.VaccinesDTO
import com.integrated.medical.records.domain.dto.toEntity
import com.integrated.medical.records.domain.toDTO
import com.integrated.medical.records.exception.ObjectNotFoundException
import com.integrated.medical.records.repository.VaccineRepository
import com.integrated.medical.records.service.VaccineService
import org.springframework.stereotype.Service

@Service
class VaccineServiceImpl(val vaccineRepository: VaccineRepository) : VaccineService {

    override fun getAllVaccines(): List<VaccinesDTO>? {

        val listOfVaccines = vaccineRepository.findAll()
        return listOfVaccines.toList().toDTO()

    }

    override fun getVaccine(idVaccine: Int): VaccinesDTO? {

        val vaccine = vaccineRepository.findById(idVaccine).orElseThrow {
            throw ObjectNotFoundException("Vaccine not found")
        }

        return vaccine.toDTO()
    }

    override fun updateVaccine(vaccinesDTO: VaccinesDTO): VaccinesDTO {
        vaccineRepository.findById(vaccinesDTO.idVaccine).orElseThrow {
            throw ObjectNotFoundException("Emergency Card not found")
        }
        return vaccineRepository.save(vaccinesDTO.toEntity()).toDTO()
    }

    override fun addVaccine(vaccinesDTO: VaccinesDTO) {
        // TODO Add validation to avoid insert duplicate values
        vaccineRepository.save(vaccinesDTO.toEntity())
    }

    override fun deleteVaccine(vaccinesDTO: VaccinesDTO) {
        vaccineRepository.deleteById(vaccinesDTO.idVaccine)
    }

}
package com.integrated.medical.records.service

import com.integrated.medical.records.domain.dto.VaccinesDTO
import org.springframework.stereotype.Service

@Service
interface VaccineService {
    fun getAllVaccines(): List<VaccinesDTO>?
    fun getVaccine(idVaccine:Int): VaccinesDTO?
    fun updateVaccine(vaccinesDTO: VaccinesDTO) : VaccinesDTO
    fun addVaccine(vaccinesDTO: VaccinesDTO)
    fun deleteVaccine(vaccinesDTO: VaccinesDTO)
}
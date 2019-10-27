package com.integrated.medical.records.domain.dto

import com.integrated.medical.records.domain.Vaccine
import java.io.Serializable


data class VaccinesDTO(
        var idVaccine: Int = 0,

        var name: String = "",

        var description: String = "",

        var numberDoses: Int?
) : Serializable {
    // TODO mapping in kotlin
        //https://tp21.se/blog/2017/12/07/dto-mapping-in-kotlin/
        //https://stackoverflow.com/questions/39199426/better-way-to-map-kotlin-data-objects-to-data-objects
        //https://www.baeldung.com/kotlin-data-objects
}

fun List<VaccinesDTO>.toDTO(): List<Vaccine>{
    return map { it.toEntity() }
}

fun VaccinesDTO.toEntity(): Vaccine {
    var vaccine = Vaccine(
            this.idVaccine,
            this.name,
            this.description,
            this.numberDoses
    )
    return vaccine
}

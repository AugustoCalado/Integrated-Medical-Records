package com.integrated.medical.records.domain.dto


data class VaccinesDTO(
        var idVaccine: Int? = 0,

        var name: String = "",

        var description: String = "",

        var nDoses: Int = 0
) {
//https://tp21.se/blog/2017/12/07/dto-mapping-in-kotlin/
  //  https://stackoverflow.com/questions/39199426/better-way-to-map-kotlin-data-objects-to-data-objects
    //https://www.baeldung.com/kotlin-data-objects
}
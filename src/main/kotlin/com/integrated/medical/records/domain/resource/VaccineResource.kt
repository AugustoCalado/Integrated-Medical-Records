package com.integrated.medical.records.domain.resource

import com.integrated.medical.records.domain.Vaccine
import org.springframework.hateoas.ResourceSupport

class VaccineResource(

        val name: String,

        val description: String,

        val nDoses: Int
) : ResourceSupport() {

    constructor(vaccine: Vaccine) : this(
            vaccine.name,
            vaccine.description,
            vaccine.numberDoses
    ) {
        print("Augusto")
    }
}
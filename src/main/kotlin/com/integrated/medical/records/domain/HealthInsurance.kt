package com.integrated.medical.records.domain

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "HEALTH_INSURANCE", schema = "MEDICAL_RECORDS")
class HealthInsurance (


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "idHEALTH_INSURANCE")
        @NotNull
        val idHealthInsurance: Int,


        @Column(name = "HEALTH_INSURANCE_COMPANY", length = 255)
        @NotNull
        val healthInsuranceCompany: String,


        @Column(name = "HEALTH_INSURANCE_NAME", length = 360)
        @NotNull
        val healthInsuranceName: String,

        @Column(name = "INSURANCE_CARD_NUMBER", length = 30)
        @NotNull
        val insuranceCardNumber: String,

        @Column(name = "CARD_EXPIRATION_DATE")
        val cardExpirationDate: Int
        //042021 == 04/2021


) {

    @ManyToOne
    @JoinColumn(name = "PATIENTS_idPATIENTS")
    lateinit var patient: Patient

}
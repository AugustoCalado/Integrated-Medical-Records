package com.integrated.medical.records

import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class IntegratedMedicalRecordsApplication

fun main(args: Array<String>) {
	runApplication<IntegratedMedicalRecordsApplication>(*args)

	@Bean
	fun modelMapper(): ModelMapper {
		return ModelMapper()
	}
}



fun testMyApplication () {

}

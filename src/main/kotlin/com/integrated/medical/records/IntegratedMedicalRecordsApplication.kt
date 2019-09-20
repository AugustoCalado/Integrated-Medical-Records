package com.integrated.medical.records

import com.integrated.medical.records.repository.ImmunizationScheduleRepository
import jdk.nashorn.internal.runtime.regexp.joni.Config.log
import org.modelmapper.ModelMapper
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class IntegratedMedicalRecordsApplication {


}

fun main(args: Array<String>) {
    runApplication<IntegratedMedicalRecordsApplication>(*args)

    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }

}


@Bean
fun init(repository: ImmunizationScheduleRepository) = CommandLineRunner {
    print("CommandLineRunner method")
}


package com.integrated.medical.records.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean
import org.springframework.core.io.Resource;


@Configuration
class RepositoryPopulatorConfig {

    @Bean
    fun getRespositoryPopulator(): Jackson2RepositoryPopulatorFactoryBean {
        val factory = Jackson2RepositoryPopulatorFactoryBean()
        factory.setResources(arrayOf<Resource>(
                ClassPathResource("vaccine-data.json")
            )
        )
        return factory
    }

}
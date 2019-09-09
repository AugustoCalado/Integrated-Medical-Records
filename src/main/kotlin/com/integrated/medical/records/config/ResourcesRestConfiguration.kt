package com.integrated.medical.records.config

import com.integrated.medical.records.controller.VaccineController
import com.integrated.medical.records.domain.Vaccine
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.hateoas.EntityLinks
import org.springframework.hateoas.PagedResources
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceProcessor


@Configuration
class ResourcesRestConfiguration {

//    PagedResources<Resource<Vaccine>>>
//    ResourceProcessor<PagedResources<Resource<Vaccine>>>
    @Bean
    fun vaccineProcessor(links: EntityLinks): ResourceProcessor<Resource<Vaccine>> {

        return ResourceProcessor<Resource<Vaccine>> { resource ->
            resource.add(
                    links.linkFor(Vaccine::class.java)
                        .slash("get").slash("all")
                            .withRel("geral")

            )
            // TODO [perform test with spring security acessing the the method in controller class]
            resource
        }
    }

}
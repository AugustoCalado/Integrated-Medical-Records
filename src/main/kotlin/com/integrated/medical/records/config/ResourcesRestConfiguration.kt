package com.integrated.medical.records.config

import com.integrated.medical.records.domain.Vaccine
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.hateoas.EntityLinks
import org.springframework.hateoas.PagedResources
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceProcessor


@Configuration
class ResourcesRestConfiguration {


    @Bean
    fun vaccineProcessor(links: EntityLinks): ResourceProcessor<PagedResources<Resource<Vaccine>>> {

        return ResourceProcessor<PagedResources<Resource<Vaccine>>> { resource ->
            resource.add(
                    links.linkFor(Vaccine::class.java)
                            .slash("recent")
                            .withRel("recents"))
            resource
        }
    }

}
package com.integrated.medical.records.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.web.filter.CorsFilter


@Configuration
class CorsConfig {

//    @Bean
//    fun corsConfigurationSource(): CorsConfigurationSource {
//        val source = UrlBasedCorsConfigurationSource()
//        source.registerCorsConfiguration("/**", CorsConfiguration().applyPermitDefaultValues())
//
//        return source
//    }


    @Bean
    fun corsConfigurationSource(): FilterRegistrationBean<*> {
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", CorsConfiguration().applyPermitDefaultValues())
        val bean = FilterRegistrationBean(CorsFilter(source))
        bean.setOrder(0)
        return bean
    }

//    @Bean
//
//    fun corsFilter(): FilterRegistrationBean<*> {
//        val source = UrlBasedCorsConfigurationSource()
//        val config = CorsConfiguration()
//        config.allowCredentials = true
//        config.addAllowedOrigin("http://domain1.com")
//        config.addAllowedHeader("*")
//        config.addAllowedMethod("*")
//        source.registerCorsConfiguration("/**", config)
//        val bean = FilterRegistrationBean(CorsFilter(source))
//        bean.setOrder(0)
//        return bean
//    }


}
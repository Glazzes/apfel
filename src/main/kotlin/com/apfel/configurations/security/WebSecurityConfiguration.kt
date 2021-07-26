package com.apfel.configurations.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.cors.CorsConfiguration

@EnableWebSecurity
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        super.configure(auth)
    }

    override fun configure(http: HttpSecurity) {
       http.csrf().disable()
           .cors().configurationSource {
               val corsConfiguration = CorsConfiguration()
               corsConfiguration.allowedOrigins = listOf("http://localhost:19006")
               corsConfiguration.allowedMethods = listOf("GET", "POST", "OPTIONS")
               corsConfiguration.allowedHeaders = listOf("*")
               corsConfiguration.allowCredentials = true
               corsConfiguration.maxAge = 3600

               corsConfiguration
           }

        http.authorizeRequests()
            .antMatchers("/wsa").authenticated()
            .anyRequest().permitAll()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

}
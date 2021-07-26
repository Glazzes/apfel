package com.apfel.configurations.security.models

import com.apfel.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class ApfelUserDetailsService(private val userService: UserService) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return userService.findByUsername(username)
            .map { ApfelUserDetails(it) }
            .orElseThrow { UsernameNotFoundException("No existe un usuario con el nombre $username") }
    }
}
package com.apfel.service

import com.apfel.entities.User
import com.apfel.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun existsByUsername(username: String): Boolean {
        return userRepository.existsByUsername(username)
    }

    fun findById(id: Long): Optional<User>{
        return userRepository.findById(id)
    }

    fun findByUsername(username: String): Optional<User>{
        return userRepository.findByUsername(username)
    }

}
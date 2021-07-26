package com.apfel.entities.models

import com.apfel.shared.validators.usernamevalidator.UniqueUsername
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotBlank

class SignUpRequest (
    @get:NotBlank
    val realName: String,

    @get:UniqueUsername
    @get:Length(min = 4, max = 50, message = "El nombre de usuario debe tener entre 4 y 50 caracteres.")
    val username: String,

    @get:Length(min = 8, max = 50, message = "La contraseña debe tener entre 8 y 50 caracteres.")
    val password: String,
)
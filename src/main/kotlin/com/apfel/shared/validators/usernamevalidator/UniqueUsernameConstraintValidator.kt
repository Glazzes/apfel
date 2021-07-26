package com.apfel.shared.validators.usernamevalidator

import com.apfel.service.UserService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UniqueUsernameConstraintValidator(private val userService: UserService)
    : ConstraintValidator<UniqueUsername, String> {

    override fun isValid(value: String, context: ConstraintValidatorContext?): Boolean {
        return !userService.existsByUsername(value)
    }
}
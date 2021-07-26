package com.apfel.shared.validators.usernamevalidator

import org.springframework.messaging.handler.annotation.Payload
import javax.validation.Constraint
import kotlin.reflect.KClass

@Retention(value = AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.FIELD])
@Constraint(validatedBy = [UniqueUsernameConstraintValidator::class])
annotation class UniqueUsername(
    val message: String = "Este nombre de usuario ya esta en uso.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
)

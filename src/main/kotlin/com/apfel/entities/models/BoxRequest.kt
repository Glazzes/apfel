package com.apfel.entities.models

import javax.validation.constraints.NotBlank

class BoxRequest(
    @get:NotBlank
    val boxId: String,

    @get:NotBlank
    val workerId: Long,
)
package com.apfel.shared.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(value = [NotFoundException::class])
    fun handleNotFoundException(e: NotFoundException): ResponseEntity<*>{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(e.message)
    }

}
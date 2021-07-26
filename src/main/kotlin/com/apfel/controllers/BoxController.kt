package com.apfel.controllers

import com.apfel.entities.models.BoxRequest
import com.apfel.service.BoxService
import com.apfel.service.BoxWebSocketService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/box")
class BoxController(val boxService: BoxService, val boxWebSocketService: BoxWebSocketService) {

    @PostMapping
    fun saveNewBox(@Valid @RequestBody boxRequest: BoxRequest): ResponseEntity<*> {
        val newBox = boxService.saveNewBox(boxRequest.boxId, boxRequest.workerId)
        boxWebSocketService.reportNewBoxToWorker(newBox, boxRequest.workerId)

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(newBox)
    }

}
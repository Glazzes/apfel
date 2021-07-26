package com.apfel.service

import com.apfel.entities.Box
import com.apfel.repository.BoxRepository
import com.apfel.shared.exceptions.NotFoundException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class BoxService(val userService: UserService, val boxRepository: BoxRepository) {

    fun saveNewBox(boxId: String, workerId: Long): Box{
        val user = userService.findById(workerId)
            .orElseThrow { NotFoundException("No se puede registrar la caja $boxId, porque el usuario con id $workerId no existe.") }

        return boxRepository.save(Box(boxId = boxId, user = user))
    }

}
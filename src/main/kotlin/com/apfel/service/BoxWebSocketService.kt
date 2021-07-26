package com.apfel.service

import com.apfel.entities.Box
import com.apfel.entities.models.BoxPayload
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class BoxWebSocketService(val messagingTemplate: SimpMessagingTemplate) {

    fun reportNewBoxToWorker(box: Box, workerId: Long){
        val topic = "/workers/$workerId/boxes"
        val payload = BoxPayload(box.boxId, workerId)
        messagingTemplate.convertAndSend(topic, payload)
    }

}
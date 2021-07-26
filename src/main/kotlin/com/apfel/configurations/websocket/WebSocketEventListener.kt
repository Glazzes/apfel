package com.apfel.configurations.websocket

import com.apfel.configurations.security.models.ApfelUserDetails
import com.apfel.shared.enums.Operation
import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import java.security.Principal

@Component
class WebSocketEventListener(private val messagingTemplate: SimpMessagingTemplate) {
    private val topic: String = "/workers"

    @EventListener(value = [SessionConnectEvent::class])
    fun onSessionConnectEvent(sessionEvent: SessionConnectEvent) {
        sessionEvent.user?.let {
            processSessionEvent(it, Operation.ADD)
        }
    }

    @EventListener(value = [SessionDisconnectEvent::class])
    fun onSessionDisconnectEvent(sessionEvent: SessionDisconnectEvent){
        sessionEvent.user?.let {
            processSessionEvent(it, Operation.REMOVE)
        }
    }

    private fun processSessionEvent(principal: Principal, operation: Operation){
        val payload = WebSocketEvent("", principal.name, operation)
        messagingTemplate.convertAndSend(topic, payload)
    }

    data class WebSocketEvent(val id: String, val realName: String, val operation: Operation)

}
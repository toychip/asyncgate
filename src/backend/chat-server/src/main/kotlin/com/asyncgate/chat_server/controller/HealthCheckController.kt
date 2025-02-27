package com.asyncgate.chat_server.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthCheckController {

    @GetMapping
    fun healthCheck(): Map<String, String> {
        return mapOf("status" to "UP")
    }
}

package com.asyncgate.signaling_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestQueryController {

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
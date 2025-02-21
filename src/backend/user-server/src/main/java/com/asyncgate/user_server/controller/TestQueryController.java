package com.asyncgate.user_server.controller;

import com.asyncgate.user_server.support.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@RequiredArgsConstructor
public class TestQueryController {

    /**
     * 0.0 security no need 테스트용 get method
     */
    @GetMapping("/health")
    public SuccessResponse<String> health() {
        return SuccessResponse.ok("security no need");
    }
}

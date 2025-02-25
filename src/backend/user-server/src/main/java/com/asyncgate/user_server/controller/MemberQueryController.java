package com.asyncgate.user_server.controller;

import com.asyncgate.user_server.security.annotation.MemberID;
import com.asyncgate.user_server.support.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 1.7 회원 화상 간단 정보 조회
     */
    @Override
    @GetMapping("/room/profile")
    public SuccessResponse<?> readUserRoomProfile(@MemberID String userId) {
        return SuccessResponse.ok("회원탈퇴 완료");
    }
}

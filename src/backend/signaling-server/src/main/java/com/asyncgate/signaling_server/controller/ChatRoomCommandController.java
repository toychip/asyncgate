package com.asyncgate.signaling_server.controller;

import com.asyncgate.signaling_server.dto.request.CreateRoomRequest;
import com.asyncgate.signaling_server.usecase.CreateRoomUseCase;
import com.asyncgate.signaling_server.usecase.JoinRoomUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.asyncgate.signaling_server.support.response.SuccessResponse;

import java.util.Map;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class ChatRoomCommandController {

    private final CreateRoomUseCase createRoomUseCase;
    private final JoinRoomUseCase joinRoomUseCase;

    @PostMapping("/create")
    public SuccessResponse<String> createRoom(@RequestBody CreateRoomRequest request) {
        createRoomUseCase.execute(request);
        return SuccessResponse.ok("room 생성 완료");
    }

    @PostMapping("/{room_id}/join")
    public SuccessResponse<String> joinRoom(@PathVariable("room_id") String roomId,
                                            @RequestBody Map<String, String> requestBody) {
        String memberId = requestBody.get("member_id"); // JSON에서 member_id 추출
        if (memberId == null || memberId.isEmpty()) {
            throw new IllegalArgumentException("Member ID는 필수입니다.");
        }
        joinRoomUseCase.execute(roomId, memberId);
        return SuccessResponse.ok("room 참가 완료");
    }

}

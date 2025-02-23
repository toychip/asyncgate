package com.asyncgate.signaling_server.controller;

import com.asyncgate.signaling_server.dto.request.CreateRoomRequest;
import com.asyncgate.signaling_server.dto.response.GetUsersInChannelResponse;
import com.asyncgate.signaling_server.security.annotation.MemberID;
import com.asyncgate.signaling_server.signaling.KurentoManager;
import com.asyncgate.signaling_server.usecase.CreateRoomUseCase;
import com.asyncgate.signaling_server.usecase.ExitRoomUseCase;
import com.asyncgate.signaling_server.usecase.JoinRoomUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import com.asyncgate.signaling_server.support.response.SuccessResponse;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class ChatRoomCommandController {

    private final CreateRoomUseCase createRoomUseCase;
    private final JoinRoomUseCase joinRoomUseCase;
    private final ExitRoomUseCase exitRoomUseCase;

    /**
     * 채널 생성
     */
    @PostMapping("/create")
    public SuccessResponse<String> createRoom(@RequestBody final CreateRoomRequest request, @MemberID final String memberId) {
        createRoomUseCase.execute(request, memberId);
        return SuccessResponse.ok("room 생성 완료: " + request.roomId());
    }

    /**
     * 채널 참여
     */
    @PostMapping("/{room_id}/join")
    public SuccessResponse<String> joinRoom(@PathVariable("room_id") final String roomId, @MemberID final String memberId) {
        joinRoomUseCase.execute(roomId, memberId);
        return SuccessResponse.ok("room: " + roomId + "에 user: " + memberId + "가 참여하였습니다.");
    }

    /**
     * 채널에 참여 중인 유저 조회
     */
    @GetMapping("/{room_id}/users")
    public SuccessResponse<GetUsersInChannelResponse> getUsersInRoom(@PathVariable("room_id") String roomId) {
        return SuccessResponse.ok(
                GetUsersInChannelResponse.builder()
                        .users(kurentoManager.getUsersInChannel(roomId))
                        .build()
        );
    }

    /**
     * 유저 퇴장 API
     */
    @PostMapping("/{roomId}/exit")
    public SuccessResponse<String> exitRoom(@PathVariable("roomId") String roomId, @MemberID final String memberId) {

        exitRoomUseCase.execute(roomId, memberId);
        return SuccessResponse.ok("room: " + roomId + "의 user : " + memberId + "가 퇴장하였습니다.");
    }
}

package com.asyncgate.user_server.controller.docs;

import com.asyncgate.user_server.dto.response.FriendResponse;
import com.asyncgate.user_server.dto.response.FriendsResponse;
import com.asyncgate.user_server.dto.response.UserClientInfoResponses;
import com.asyncgate.user_server.security.annotation.MemberID;
import com.asyncgate.user_server.support.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

public interface FriendControllerDocs {

    @Operation(summary = "회원 검색", description = "이메일을 기반으로 회원 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "정상적으로 조회되었습니다.")
    })
    @GetMapping
    SuccessResponse<UserClientInfoResponses.UserClientInfoResponse> searchTarget(
            @Parameter(description = "검색할 회원의 이메일", required = true)
            @RequestParam String email
    );


    @Operation(summary = "친구 요청", description = "현재 사용자(@MemberID)가 지정된 toUserId에게 친구 요청을 보냅니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "친구 요청이 생성되었습니다.")
    })
    @PostMapping("/request/{toUserId}")
    SuccessResponse<FriendResponse> requestFriend(
            @Parameter(hidden = true) @MemberID String userId,
            @Parameter(description = "친구 요청 대상의 사용자 ID", required = true)
            @PathVariable String toUserId
    );


    @Operation(summary = "친구 요청 수락", description = "현재 사용자(@MemberID)가 friendId에 해당하는 친구 요청을 수락합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "친구 요청이 수락되었습니다.")
    })
    @PostMapping("/accept/{friendId}")
    SuccessResponse<FriendResponse> acceptFriend(
            @Parameter(hidden = true) @MemberID String userId,
            @Parameter(description = "수락할 친구 요청의 ID", required = true)
            @PathVariable String friendId
    );


    @Operation(summary = "친구 요청 거절", description = "현재 사용자(@MemberID)가 friendId에 해당하는 친구 요청을 거절합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "친구 요청이 거절되었습니다.")
    })
    @PostMapping("/reject/{friendId}")
    SuccessResponse<FriendResponse> rejectFriend(
            @Parameter(hidden = true) @MemberID String userId,
            @Parameter(description = "거절할 친구 요청의 ID", required = true)
            @PathVariable String friendId
    );


    @Operation(summary = "친구 삭제", description = "현재 사용자(@MemberID)가 friendId에 해당하는 친구 관계를 삭제(soft delete)합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "친구 관계가 삭제되었습니다.")
    })
    @DeleteMapping("/{friendId}")
    SuccessResponse<String> deleteFriend(
            @Parameter(hidden = true) @MemberID String userId,
            @Parameter(description = "삭제할 친구 관계의 ID", required = true)
            @PathVariable String friendId
    );


    @Operation(summary = "보낸 친구 요청 목록 조회", description = "현재 사용자(@MemberID)가 보낸 친구 요청 목록(PENDING)을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "보낸 친구 요청 목록이 조회되었습니다.")
    })
    @GetMapping("/sent")
    SuccessResponse<FriendsResponse> getSentFriendRequests(
            @Parameter(hidden = true) @MemberID String userId
    );


    @Operation(summary = "받은 친구 요청 목록 조회", description = "현재 사용자(@MemberID)가 받은 친구 요청 목록(PENDING)을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "받은 친구 요청 목록이 조회되었습니다.")
    })
    @GetMapping("/received")
    SuccessResponse<FriendsResponse> getReceivedFriendRequests(
            @Parameter(hidden = true) @MemberID String userId
    );


    @Operation(summary = "친구 목록 조회", description = "현재 사용자(@MemberID)의 실제 친구 목록(ACCEPTED)을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "친구 목록이 조회되었습니다.")
    })
    @GetMapping("/list")
    SuccessResponse<FriendsResponse> getFriends(
            @Parameter(hidden = true) @MemberID String userId
    );
}

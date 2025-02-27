package com.asyncgate.guild_server.controller;

import com.asyncgate.guild_server.dto.request.DirectChannelCreateRequest;
import com.asyncgate.guild_server.dto.response.DirectResponse;
import com.asyncgate.guild_server.service.DirectService;
import com.asyncgate.guild_server.support.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/direct")
public class DirectController {

    private final DirectService directService;

    @PostMapping
    public SuccessResponse<DirectResponse> create(
            final @AuthenticationPrincipal String currentUserId,
            final @RequestBody DirectChannelCreateRequest request
    ) {
        return SuccessResponse.created(
                directService.create(currentUserId, request)
        );
    }
}

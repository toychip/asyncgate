package com.asyncgate.user_server.controller;

import com.asyncgate.user_server.domain.Member;
import com.asyncgate.user_server.dto.response.MemberResponse;
import com.asyncgate.user_server.usecase.FriendUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {

    private final FriendUseCase friendUsecase;

    @GetMapping
    public MemberResponse searchTarget(final @RequestParam String email) {
        Member findMember = friendUsecase.getByEmail(email);
        return MemberResponse.from(findMember);
    }
}

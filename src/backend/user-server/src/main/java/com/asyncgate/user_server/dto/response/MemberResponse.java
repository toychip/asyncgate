package com.asyncgate.user_server.dto.response;

import com.asyncgate.user_server.domain.Member;

import java.time.LocalDate;

public record MemberResponse(String email, String name, String nickname, String profileImgUrl, LocalDate birth) {

    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getEmail(), member.getName(), member.getNickname(), member.getProfileImgUrl(), member.getBirth());
    }

}

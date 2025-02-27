package com.asyncgate.user_server.dto.response;

import com.asyncgate.user_server.domain.Member;

import java.util.List;

public record UserClientInfoResponses(List<UserClientInfoResponse> responses) {
    public static UserClientInfoResponses from(List<Member> members) {
        return new UserClientInfoResponses(
                members.stream()
                .map(UserClientInfoResponse::from)
                .toList()
        );
    }

    private record UserClientInfoResponse(String userId, String name, String nickname, String profileImageUrl) {
        private static UserClientInfoResponse from(final Member member) {
            return new UserClientInfoResponse(
                    member.getId(), member.getName(), member.getNickname(), member.getProfileImgUrl()
            );
        }
    }
}

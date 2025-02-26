package com.asyncgate.signaling_server.infrastructure.client;

import com.asyncgate.signaling_server.domain.Member;
import com.asyncgate.signaling_server.exception.FailType;
import com.asyncgate.signaling_server.exception.SignalingServerException;
import com.asyncgate.signaling_server.infrastructure.dto.response.ReadUserRoomProfileResponse;
import com.asyncgate.signaling_server.infrastructure.utility.HttpClientUtil;
import com.asyncgate.signaling_server.support.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberServiceClientImpl implements MemberServiceClient {

    @Value("${service.member.url}")
    private String memberServiceUrl;

    @Override
    public Member fetchMemberById(String userId, String roomId) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("userId", userId);

        SuccessResponse<ReadUserRoomProfileResponse> response = HttpClientUtil.get(
                memberServiceUrl, "/room/profile", queryParams, SuccessResponse.class);

        if (response == null || response.getResult() == null) {
            throw new SignalingServerException(FailType._MEMBER_NOT_FOUND);
        }

        ReadUserRoomProfileResponse userProfile = response.getResult();
        return Member.create(userId, roomId, userProfile.getProfileImageUrl(), userProfile.getNickname());
    }
}
package com.asyncgate.user_server.usecase;

import com.asyncgate.user_server.dto.response.UserClientInfoResponses;

import java.util.List;

public interface FindUserInfoUseCase {

    UserClientInfoResponses getByUserIds(List<String> memberIds);
}

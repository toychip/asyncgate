package com.asyncgate.guild_server.client;

import com.asyncgate.guild_server.support.response.SuccessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-server")
public interface UserClient {

    @GetMapping("/users")
    SuccessResponse<UserClientInfoResponses> getUsersInfo(@RequestParam(required = false) List<String> memberIds);
}

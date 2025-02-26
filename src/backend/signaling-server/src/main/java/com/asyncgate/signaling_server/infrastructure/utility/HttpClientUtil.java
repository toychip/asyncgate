package com.asyncgate.signaling_server.infrastructure.utility;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class HttpClientUtil {
    private static final RestTemplate restTemplate = new RestTemplate();

    // GET 요청 (쿼리 파라미터 지원)
    public static <T> T get(String baseUrl, String path, Map<String, String> queryParams, Class<T> responseType) {
        String url = UriComponentsBuilder.fromUriString(baseUrl + path)
                .queryParams(toMultiValueMap(queryParams))
                .toUriString();

        return restTemplate.getForObject(url, responseType);
    }

    // POST 요청 (Request Body 포함)
    public static <T, R> T post(String baseUrl, String path, R requestBody, Class<T> responseType) {
        String url = baseUrl + path;
        return restTemplate.postForObject(url, requestBody, responseType);
    }

    public static MultiValueMap<String, String> toMultiValueMap(Map<String, String> map) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        map.forEach(multiValueMap::add);
        return multiValueMap;
    }
}

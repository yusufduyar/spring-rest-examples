package com.spring5.restexamples.clientexamples.services;

import com.spring5.restexamples.api.domain.User;
import com.spring5.restexamples.api.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ApiService implements IApiService {

    private RestTemplate restTemplate;

    private final String apiUrl;

    public ApiService(RestTemplate restTemplate, @Value("${api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl=apiUrl;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(apiUrl)
                .queryParam("limit",limit);

        UserData userData = restTemplate.getForObject(uriComponentsBuilder.toUriString(),UserData.class);
        return userData.getData();
    }
}

package com.spring5.restexamples.clientexamples.services;

import com.spring5.restexamples.api.domain.User;
import com.spring5.restexamples.api.domain.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiService implements IApiService {

    private RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit="+limit,UserData.class);
        return userData.getData();
    }
}

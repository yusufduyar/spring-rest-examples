package com.spring5.restexamples.clientexamples.services;

import com.spring5.restexamples.api.domain.User;

import java.util.List;

public interface IApiService {
    List<User> getUsers(Integer limit);
}

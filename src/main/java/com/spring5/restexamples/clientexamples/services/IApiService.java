package com.spring5.restexamples.clientexamples.services;

import com.spring5.restexamples.api.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IApiService {
    List<User> getUsers(Integer limit);

    Flux<User> getUsers(Mono<Integer> limit);
}

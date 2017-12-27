package com.spring5.restexamples.clientexamples.services;

import com.spring5.restexamples.api.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceTest {

    @Autowired
    IApiService apiService;

    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void getUsersTest() throws Exception {
        List<User> users = apiService.getUsers(3);

        assertEquals(4,users.size());
    }

}
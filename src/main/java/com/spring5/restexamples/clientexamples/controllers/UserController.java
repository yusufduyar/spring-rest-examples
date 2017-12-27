package com.spring5.restexamples.clientexamples.controllers;

import com.spring5.restexamples.clientexamples.services.IApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Controller
public class UserController {
    private IApiService apiService;

    public UserController(IApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"","/","/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users")
    public String post(Model model, ServerWebExchange serverWebExchange){
        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

        Integer limit = new Integer(map.get("limit").get(0));

        if(limit == null || limit == 0){
            limit = 10;
        }
        model.addAttribute("users",apiService.getUsers(limit-1));
        return "userlist";
    }
}

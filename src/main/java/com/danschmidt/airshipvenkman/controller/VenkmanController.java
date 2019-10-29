package com.danschmidt.airshipvenkman.controller;

import com.danschmidt.airshipvenkman.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenkmanController {
    @PostMapping(path = "/api/tags", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User tag(@RequestBody User user) {
        User returnedUser = new User("dave");
        return returnedUser;
    }
}
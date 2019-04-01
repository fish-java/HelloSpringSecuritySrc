package com.github.fish56.hello_spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Users {
    @GetMapping
    public String getUsers(){
        return "This is users list, should only admin can visit this";
    }
}

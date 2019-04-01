package com.github.fish56.hello_spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Root {
    @GetMapping
    public String getRoot(){
        return "This is root page, anyone can visit this";
    }
}
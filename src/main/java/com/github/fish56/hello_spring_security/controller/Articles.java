package com.github.fish56.hello_spring_security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class Articles {
    @PostMapping
    public String postArticle(){
        return "This is article list, a user can post article";
    }
}
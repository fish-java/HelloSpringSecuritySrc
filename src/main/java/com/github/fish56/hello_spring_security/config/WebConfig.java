package com.github.fish56.hello_spring_security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("super-admin")
                .password("{noop}123456")
                .roles("isUser","isAdmin")
                .and()
                .withUser("user")
                .password("{noop}123456")
                .roles("isUser")
                .and()
                .withUser("only-admin")
                .password("{noop}123456")
                .roles("isAdmin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
              .antMatchers("/")
                .permitAll()
              .antMatchers("/users")
                .hasRole("isAdmin")
              .antMatchers("/articles")
                .hasRole("isUser")
                .and()
              .formLogin()
                .permitAll();
    }
}

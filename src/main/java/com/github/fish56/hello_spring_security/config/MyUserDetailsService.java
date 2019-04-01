package com.github.fish56.hello_spring_security.config;

import com.github.fish56.hello_spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException
    {
        Optional<com.github.fish56.hello_spring_security.entity.User>
                user = userRepository.findById(username);
        if(!user.isPresent()){
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        String password = "{noop}" +
                user.map(com.github.fish56.hello_spring_security.entity.User::getPassword).get();

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        if(user.map(com.github.fish56.hello_spring_security.entity.User::getAdmin).get()){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("isAdmin"));
        }
        if(user.map(com.github.fish56.hello_spring_security.entity.User::getUser).get()){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("isUser"));
        }

        return new User(username, password, simpleGrantedAuthorities);
    }
}

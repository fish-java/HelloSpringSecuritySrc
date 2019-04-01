package com.github.fish56.hello_spring_security.repository;

import com.github.fish56.hello_spring_security.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}

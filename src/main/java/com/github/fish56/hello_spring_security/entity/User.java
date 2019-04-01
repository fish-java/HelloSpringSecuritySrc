package com.github.fish56.hello_spring_security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @Column(columnDefinition = "varchar(20)")
    private String name;
    private String password;
    private Boolean isAdmin;
    private Boolean isUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getUser() {
        return isUser;
    }

    public void setUser(Boolean user) {
        isUser = user;
    }
}

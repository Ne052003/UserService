package com.neoapps.userService.domain.usecases.dtos;

import com.neoapps.userService.domain.model.Role;
import com.neoapps.userService.domain.model.User;

public class UserCredentials {
    private Long id;
    private String emailAddress;
    private String password;
    private Role role;

    public UserCredentials(User user) {
        if (user == null) return;
        id = user.getId();
        emailAddress = user.getEmailAddress();
        password = user.getPassword();
        role = user.getRole();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

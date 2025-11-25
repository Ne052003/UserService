package com.neoapps.userService.domain.usecases.dtos;

import java.time.LocalDateTime;

public class UpdateUserLoginRequest {
    private String email;
    private LocalDateTime lastLogin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}

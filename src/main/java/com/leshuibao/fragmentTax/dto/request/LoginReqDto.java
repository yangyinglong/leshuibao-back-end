package com.leshuibao.fragmentTax.dto.request;

import org.springframework.stereotype.Component;

@Component
public class LoginReqDto {

    private String username;
    private String password;
    private boolean rememberPassword;

    public LoginReqDto() {
    }

    public LoginReqDto(String username, String password, boolean rememberPassword) {
        this.username = username;
        this.password = password;
        this.rememberPassword = rememberPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberPassword() {
        return rememberPassword;
    }

    public void setRememberPassword(boolean rememberPassword) {
        this.rememberPassword = rememberPassword;
    }
}

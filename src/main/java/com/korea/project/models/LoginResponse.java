package com.korea.project.models;

public class LoginResponse {

    private final String username;
    private final String jwt;

    public String getUsername() { return username; }
    public String getJwt() { return jwt; }

    public LoginResponse(String username, String jwt) {
        this.username = username;
        this.jwt = jwt;
    }
}

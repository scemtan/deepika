package com.sct.flixbus.flixbus.api.domain;

public class AuthenticationRequest {

    private final String email;
    private final String password;

    public AuthenticationRequest(String email, String password) {
        this.email    = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}

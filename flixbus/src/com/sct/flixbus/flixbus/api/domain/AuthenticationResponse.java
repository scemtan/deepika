package com.sct.flixbus.flixbus.api.domain;

public class AuthenticationResponse {

    private Partner partner;
    private String token;

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

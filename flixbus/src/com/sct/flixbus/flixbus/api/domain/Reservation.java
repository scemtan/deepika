package com.sct.flixbus.flixbus.api.domain;

public class Reservation {

    private String token;

    private int id;
    private int ttl;

    private DateTime created_at;
    private DateTime expired_at;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public DateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(DateTime created_at) {
        this.created_at = created_at;
    }

    public DateTime getExpired_at() {
        return expired_at;
    }

    public void setExpired_at(DateTime expired_at) {
        this.expired_at = expired_at;
    }
}

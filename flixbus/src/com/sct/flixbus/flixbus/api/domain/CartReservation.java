package com.sct.flixbus.flixbus.api.domain;

import java.util.Map;

public class CartReservation {

    private String id;
    private int ttl;

    private String token;

    private DateTime created_at;
    private DateTime expired_at;

    private Map<String, String> meta_info;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public Map<String, String> getMeta_info() {
        return meta_info;
    }

    public void setMeta_info(Map<String, String> meta_info) {
        this.meta_info = meta_info;
    }
}

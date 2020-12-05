package com.sct.flixbus.flixbus.api.domain;

public class ReservationWithMetaInfo {

    private int id;

    private String token;
    private String meta_info;

    private DateTime expired_at;
    private DateTime created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DateTime getExpired_at() {
        return expired_at;
    }

    public void setExpired_at(DateTime expired_at) {
        this.expired_at = expired_at;
    }

    public DateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(DateTime created_at) {
        this.created_at = created_at;
    }

    public String getMeta_info() {
        return meta_info;
    }

    public void setMeta_info(String meta_info) {
        this.meta_info = meta_info;
    }
}

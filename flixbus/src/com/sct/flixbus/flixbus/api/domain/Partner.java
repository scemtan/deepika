package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class Partner {

    private String id;
    private String username;
    private String email;
    private String fullname;
    private String agency_id;
    private String agency_name;

    private List<String> roles;

    private boolean sandboxed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(String agency_id) {
        this.agency_id = agency_id;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public void setAgency_name(String agency_name) {
        this.agency_name = agency_name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isSandboxed() {
        return sandboxed;
    }

    public void setSandboxed(boolean sandboxed) {
        this.sandboxed = sandboxed;
    }
}

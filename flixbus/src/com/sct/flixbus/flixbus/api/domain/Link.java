package com.sct.flixbus.flixbus.api.domain;

public class Link {

    private String rel;
    private String href;

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getRel() {
        return this.rel;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return this.href;
    }
}

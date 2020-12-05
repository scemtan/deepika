package com.sct.flixbus.flixbus.api.domain;

public class OrderInfoResourceLinks {

    private ResourceLink self;
    private ResourceLink cancel;

    public ResourceLink getSelf() {
        return self;
    }

    public void setSelf(ResourceLink self) {
        this.self = self;
    }

    public ResourceLink getCancel() {
        return cancel;
    }

    public void setCancel(ResourceLink cancel) {
        this.cancel = cancel;
    }
}

package com.sct.flixbus.flixbus.api.domain;

public class CartItemReserved {

    private int adult;
    private int children;
    private int bike_slot;

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getBike_slot() {
        return bike_slot;
    }

    public void setBike_slot(int bike_slot) {
        this.bike_slot = bike_slot;
    }
}

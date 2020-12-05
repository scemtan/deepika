package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class CartExtraProductsPassengerTrip {

    private String trip_uid;

    private CartExtraProductsFreeExtra free_extra;

    private List<CartExtraProductsExtraItem> extras;

    public String getTrip_uid() {
        return trip_uid;
    }

    public void setTrip_uid(String trip_uid) {
        this.trip_uid = trip_uid;
    }

    public CartExtraProductsFreeExtra getFree_extra() {
        return free_extra;
    }

    public void setFree_extra(CartExtraProductsFreeExtra free_extra) {
        this.free_extra = free_extra;
    }

    public List<CartExtraProductsExtraItem> getExtras() {
        return extras;
    }

    public void setExtras(List<CartExtraProductsExtraItem> extras) {
        this.extras = extras;
    }
}

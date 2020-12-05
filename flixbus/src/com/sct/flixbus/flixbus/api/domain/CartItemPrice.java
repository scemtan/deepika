package com.sct.flixbus.flixbus.api.domain;

public class CartItemPrice {

    private String currency;

    private int total;
    private int extras_total;
    private int passengers_total;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getExtras_total() {
        return extras_total;
    }

    public void setExtras_total(int extras_total) {
        this.extras_total = extras_total;
    }

    public int getPassengers_total() {
        return passengers_total;
    }

    public void setPassengers_total(int passengers_total) {
        this.passengers_total = passengers_total;
    }
}

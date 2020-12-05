package com.sct.flixbus.flixbus.api.domain;

public class AddPassengerDetailsResponse {

    private boolean result;

    private Reservation reservation;

    private Cart cart;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

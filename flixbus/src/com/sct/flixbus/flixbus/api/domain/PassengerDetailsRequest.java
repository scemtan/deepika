package com.sct.flixbus.flixbus.api.domain;

public class PassengerDetailsRequest {

    private final String id;
    private final String reservation_token;

    public PassengerDetailsRequest(CartReservation reservation) {
        this.id                = reservation.getId();
        this.reservation_token = reservation.getToken();
    }

    public String getId() {
        return id;
    }

    public String getReservation_token() {
        return reservation_token;
    }
}

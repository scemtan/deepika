package com.sct.flixbus.flixbus.api.domain;

public class PaymentListRequest {
    private final String reservationId;
    private final String reservationToken;
    private final String sessionToken;

    public PaymentListRequest(CartReservation reservation, String token) {
        this.reservationId    = reservation.getId();
        this.reservationToken = reservation.getToken();
        this.sessionToken     = token;
    }

    public String getReservationId() {
        return this.reservationId;
    }

    public String getReservationToken() {
        return this.reservationToken;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }
}

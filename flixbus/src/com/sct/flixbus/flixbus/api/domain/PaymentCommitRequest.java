package com.sct.flixbus.flixbus.api.domain;

public class PaymentCommitRequest {
    private final String reservationId;
    private final String reservationToken;
    private final String paymentId;
    private final String sessionToken;

    public PaymentCommitRequest(CartReservation reservation, String payment_id, String token) {
        this.reservationId    = reservation.getId();
        this.reservationToken = reservation.getToken();
        this.paymentId        = payment_id;
        this.sessionToken     = token;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getReservationToken() {
        return reservationToken;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getSessionToken() {
        return sessionToken;
    }
}

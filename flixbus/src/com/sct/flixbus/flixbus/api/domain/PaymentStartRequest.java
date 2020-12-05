package com.sct.flixbus.flixbus.api.domain;

public class PaymentStartRequest {
    private final String reservationId;
    private final String reservationToken;
    private final String sessionToken;
    private final String email           = "";
    private final String paymentProvider = "offline";
    private final String paymentMethod   = "cash";

    public PaymentStartRequest(CartReservation reservation, String token) {
        this.reservationId    = reservation.getId();
        this.reservationToken = reservation.getToken();
        this.sessionToken     = token;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getReservationToken() {
        return reservationToken;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public String getEmail() {
        return email;
    }

    public String getPaymentProvider() {
        return this.paymentProvider;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }
}

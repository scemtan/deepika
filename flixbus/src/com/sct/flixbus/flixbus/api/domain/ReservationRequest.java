package com.sct.flixbus.flixbus.api.domain;

public class ReservationRequest {

    private String sessionToken;
    private String trip_uid;
    private String currency  = "EUR";
    private String meta_info = "";

    private int adult = 1;
    private int children = 0;
    private int bikes = 0;

    private CartReservation reservation;

    public ReservationRequest(String trip_uid, String sessionToken) {
        this.trip_uid     = trip_uid;
        this.sessionToken = sessionToken;
    }

    public String getSessionToken(){
        return this.sessionToken;
    }

    public String getTrip_uid() {
        return this.trip_uid;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getAdult() {
        return this.adult;
    }

    public void setReservation(CartReservation reservation) {
        this.reservation = reservation;
    }

    public CartReservation getReservation() {
        return this.reservation;
    }

    public boolean hasReservation() {
        return this.reservation != null;
    }
}

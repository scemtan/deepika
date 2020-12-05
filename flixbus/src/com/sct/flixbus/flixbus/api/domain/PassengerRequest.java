package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class PassengerRequest {

    private String reservation_token;
    private String donation_partner;

    private boolean with_donation;

    private List<Passenger> passengers;

    public PassengerRequest(CartReservation reservation, String donation_partner, boolean with_donation, List<Passenger> passengers) {
        this.reservation_token = reservation.getToken();
        this.donation_partner  = donation_partner;
        this.with_donation     = with_donation;
        this.passengers        = passengers;
    }

    public String getReservation_token() {
        return reservation_token;
    }

    public String getDonation_partner() {
        return donation_partner;
    }

    public boolean isWith_donation() {
        return with_donation;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}

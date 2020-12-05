package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class PassengerDetailsResponse {

    private List<PassengerTrip> trips;

    private boolean with_donation;

    private double donation;

    public void setTrips(List<PassengerTrip> trips){
        this.trips = trips;
    }
    public List<PassengerTrip> getTrips(){
        return this.trips;
    }
    public PassengerTrip getTrip(int index){
        return this.getTrips().get(index);
    }
    public void setWith_donation(boolean with_donation){
        this.with_donation = with_donation;
    }
    public boolean getWith_donation(){
        return this.with_donation;
    }
    public void setDonation(double donation){
        this.donation = donation;
    }
    public double getDonation(){
        return this.donation;
    }
}

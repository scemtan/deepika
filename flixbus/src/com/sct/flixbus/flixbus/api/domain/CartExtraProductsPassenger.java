package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class CartExtraProductsPassenger {

    private String description;
    private String passenger_id;

    private List<CartExtraProductsPassengerTrip> trips;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(String passenger_id) {
        this.passenger_id = passenger_id;
    }

    public List<CartExtraProductsPassengerTrip> getTrips() {
        return trips;
    }

    public void setTrips(List<CartExtraProductsPassengerTrip> trips) {
        this.trips = trips;
    }
}

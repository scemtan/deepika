package com.sct.flixbus.flixbus.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({"forwarded_params"})
public class TripSearchResponse {

    private List<Trip> trips;

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Trip getTrip(int index) {
        return this.trips.get(index);
    }
}

package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class PassengerTrip {
    
    private String real_trip_uid;

    private TripStation from;
    private TripStation to;

    private DateTime departure;

    private List<Passenger> passengers;

    public String getReal_trip_uid() {
        return real_trip_uid;
    }

    public void setReal_trip_uid(String real_trip_uid) {
        this.real_trip_uid = real_trip_uid;
    }

    public TripStation getFrom() {
        return from;
    }

    public void setFrom(TripStation from) {
        this.from = from;
    }

    public TripStation getTo() {
        return to;
    }

    public void setTo(TripStation to) {
        this.to = to;
    }

    public DateTime getDeparture() {
        return departure;
    }

    public void setDeparture(DateTime departure) {
        this.departure = departure;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Passenger getPassenger(int index) {
        return this.getPassengers().get(0);
    }
}

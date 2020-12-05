package com.sct.flixbus.flixbus.api.domain;

public class AddPassengerDetailsRequest {

    private String id;

    private PassengerRequest passengerRequest;

    public AddPassengerDetailsRequest(String id, PassengerRequest passengerRequest) {
        this.id = id;
        this.passengerRequest = passengerRequest;
    }

    public String getId() {
        return id;
    }

    public PassengerRequest getPassengerRequest() {
        return passengerRequest;
    }
}

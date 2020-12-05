package com.sct.flixbus.flixbus.api.domain;

public class InterconnectionTransfer {

    private int station_id;

    private DateTime arrival;
    private DateTime departure;

    private Duration duration;

    private String message;
    private String station_name;

    boolean shuttle_transfer;

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public DateTime getArrival() {
        return arrival;
    }

    public void setArrival(DateTime arrival) {
        this.arrival = arrival;
    }

    public DateTime getDeparture() {
        return departure;
    }

    public void setDeparture(DateTime departure) {
        this.departure = departure;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public boolean isShuttle_transfer() {
        return shuttle_transfer;
    }

    public void setShuttle_transfer(boolean shuttle_transfer) {
        this.shuttle_transfer = shuttle_transfer;
    }
}

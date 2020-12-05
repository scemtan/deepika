package com.sct.flixbus.flixbus.api.domain;

public class Transfer {

    private String type;
    private String line_direction;
    private String line_code;

    private StationFull station;

    private DateTime arrival;
    private DateTime departure;

    private HumanApprovedDelay departure_had;
    private HumanApprovedDelay arrival_had;

    private Duration duration;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLine_direction() {
        return line_direction;
    }

    public void setLine_direction(String line_direction) {
        this.line_direction = line_direction;
    }

    public String getLine_code() {
        return line_code;
    }

    public void setLine_code(String line_code) {
        this.line_code = line_code;
    }

    public StationFull getStation() {
        return station;
    }

    public void setStation(StationFull station) {
        this.station = station;
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

    public HumanApprovedDelay getDeparture_had() {
        return departure_had;
    }

    public void setDeparture_had(HumanApprovedDelay departure_had) {
        this.departure_had = departure_had;
    }

    public HumanApprovedDelay getArrival_had() {
        return arrival_had;
    }

    public void setArrival_had(HumanApprovedDelay arrival_had) {
        this.arrival_had = arrival_had;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}

package com.sct.flixbus.flixbus.api.domain;

public class TripSearchRequest {

    private static final String SEARCH_BY_CITIES = "cities";

    private String search_by = SEARCH_BY_CITIES;
    private String departure_date;
    private String currency = "EUR";

    private TripStation from;
    private TripStation to;

    private int adult = 1;
    private int children = 0;
    private int bikes = 0;

    public TripSearchRequest(String departure_date, TripStation from, TripStation to) {
        this.departure_date = departure_date;
        this.from = from;
        this.to = to;
    }

    public String getSearch_by() {
        return search_by;
    }

    public void setSearch_by(String search_by) {
        this.search_by = search_by;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }
}

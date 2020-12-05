package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class OrderInfoTripSeatsPerRelation {

    private int from;
    private int to;

    private List<OrderInfoTripSeat> seats;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public List<OrderInfoTripSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<OrderInfoTripSeat> seats) {
        this.seats = seats;
    }
}

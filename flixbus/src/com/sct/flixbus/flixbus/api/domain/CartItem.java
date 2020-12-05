package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class CartItem {

    private int ride_id;
    private int passenger_count;
    private int hand_luggage_allowance;
    private int hold_luggage_allowance;

    private TripId trip;

    private CartTripStation from;
    private CartTripStation to;

    private DateTime departure;
    private DateTime arrival;

    private CartItemPrice price;

    private LineDirection line_direction;

    private List<String> messages;

    private String products_description;

    private CartItemReserved reserved;

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }

    public int getPassenger_count() {
        return passenger_count;
    }

    public void setPassenger_count(int passenger_count) {
        this.passenger_count = passenger_count;
    }

    public int getHand_luggage_allowance() {
        return hand_luggage_allowance;
    }

    public void setHand_luggage_allowance(int hand_luggage_allowance) {
        this.hand_luggage_allowance = hand_luggage_allowance;
    }

    public int getHold_luggage_allowance() {
        return hold_luggage_allowance;
    }

    public void setHold_luggage_allowance(int hold_luggage_allowance) {
        this.hold_luggage_allowance = hold_luggage_allowance;
    }

    public TripId getTrip() {
        return trip;
    }

    public void setTrip(TripId trip) {
        this.trip = trip;
    }

    public CartTripStation getFrom() {
        return from;
    }

    public void setFrom(CartTripStation from) {
        this.from = from;
    }

    public CartTripStation getTo() {
        return to;
    }

    public void setTo(CartTripStation to) {
        this.to = to;
    }

    public DateTime getDeparture() {
        return departure;
    }

    public void setDeparture(DateTime departure) {
        this.departure = departure;
    }

    public DateTime getArrival() {
        return arrival;
    }

    public void setArrival(DateTime arrival) {
        this.arrival = arrival;
    }

    public CartItemPrice getPrice() {
        return price;
    }

    public void setPrice(CartItemPrice price) {
        this.price = price;
    }

    public LineDirection getLine_direction() {
        return line_direction;
    }

    public void setLine_direction(LineDirection line_direction) {
        this.line_direction = line_direction;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getProducts_description() {
        return products_description;
    }

    public void setProducts_description(String products_description) {
        this.products_description = products_description;
    }

    public CartItemReserved getReserved() {
        return reserved;
    }

    public void setReserved(CartItemReserved reserved) {
        this.reserved = reserved;
    }
}

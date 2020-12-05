package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class OrderInfoTrip {

    private int bike_slots_count;

    private String line_direction;
    private String passbook_url;
    private String order_status;
    private String push_channel_uid;
    private String trip_uid;
    private String products_description;
    private String products_description_html;

    private boolean real_time_info_available;

    private List<OrderInfoPassenger> passengers;
    private List<Transfer> transfers;
    private List<String> warnings;

    private OrderInfoStation departure_station;
    private OrderInfoStation arrival_station;
    private DateTime departure;
    private DateTime arrival;
    private List<OrderInfoTripSeatsPerRelation> seats_per_relation;
    private List<Operator> operated_by;

    public int getBike_slots_count() {
        return bike_slots_count;
    }

    public void setBike_slots_count(int bike_slots_count) {
        this.bike_slots_count = bike_slots_count;
    }

    public String getLine_direction() {
        return line_direction;
    }

    public void setLine_direction(String line_direction) {
        this.line_direction = line_direction;
    }

    public String getPassbook_url() {
        return passbook_url;
    }

    public void setPassbook_url(String passbook_url) {
        this.passbook_url = passbook_url;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getPush_channel_uid() {
        return push_channel_uid;
    }

    public void setPush_channel_uid(String push_channel_uid) {
        this.push_channel_uid = push_channel_uid;
    }

    public String getTrip_uid() {
        return trip_uid;
    }

    public void setTrip_uid(String trip_uid) {
        this.trip_uid = trip_uid;
    }

    public String getProducts_description() {
        return products_description;
    }

    public void setProducts_description(String products_description) {
        this.products_description = products_description;
    }

    public String getProducts_description_html() {
        return products_description_html;
    }

    public void setProducts_description_html(String products_description_html) {
        this.products_description_html = products_description_html;
    }

    public boolean isReal_time_info_available() {
        return real_time_info_available;
    }

    public void setReal_time_info_available(boolean real_time_info_available) {
        this.real_time_info_available = real_time_info_available;
    }

    public List<OrderInfoPassenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<OrderInfoPassenger> passengers) {
        this.passengers = passengers;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public OrderInfoStation getDeparture_station() {
        return departure_station;
    }

    public void setDeparture_station(OrderInfoStation departure_station) {
        this.departure_station = departure_station;
    }

    public OrderInfoStation getArrival_station() {
        return arrival_station;
    }

    public void setArrival_station(OrderInfoStation arrival_station) {
        this.arrival_station = arrival_station;
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

    public List<OrderInfoTripSeatsPerRelation> getSeats_per_relation() {
        return seats_per_relation;
    }

    public void setSeats_per_relation(List<OrderInfoTripSeatsPerRelation> seats_per_relation) {
        this.seats_per_relation = seats_per_relation;
    }

    public List<Operator> getOperated_by() {
        return operated_by;
    }

    public void setOperated_by(List<Operator> operated_by) {
        this.operated_by = operated_by;
    }
}

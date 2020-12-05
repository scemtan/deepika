package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class AncillaryOffer {

    private String name;
    private String description;
    private String container_type;
    private String product_type;
    private String reference_id;
    private String headline;
    private String currency;
    private String price;
    private String trip_uid;
    private String params;

    private int max_available_count;
    private int selected_count;

    private List<String> price_list;
    private List<String> trips;
    private List<String> params_for_each_passenger;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContainer_type() {
        return container_type;
    }

    public void setContainer_type(String container_type) {
        this.container_type = container_type;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getReference_id() {
        return reference_id;
    }

    public void setReference_id(String reference_id) {
        this.reference_id = reference_id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTrip_uid() {
        return trip_uid;
    }

    public void setTrip_uid(String trip_uid) {
        this.trip_uid = trip_uid;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getMax_available_count() {
        return max_available_count;
    }

    public void setMax_available_count(int max_available_count) {
        this.max_available_count = max_available_count;
    }

    public int getSelected_count() {
        return selected_count;
    }

    public void setSelected_count(int selected_count) {
        this.selected_count = selected_count;
    }

    public List<String> getPrice_list() {
        return price_list;
    }

    public void setPrice_list(List<String> price_list) {
        this.price_list = price_list;
    }

    public List<String> getTrips() {
        return trips;
    }

    public void setTrips(List<String> trips) {
        this.trips = trips;
    }

    public List<String> getParams_for_each_passenger() {
        return params_for_each_passenger;
    }

    public void setParams_for_each_passenger(List<String> params_for_each_passenger) {
        this.params_for_each_passenger = params_for_each_passenger;
    }
}

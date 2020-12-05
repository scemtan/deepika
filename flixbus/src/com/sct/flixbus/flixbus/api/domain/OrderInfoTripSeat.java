package com.sct.flixbus.flixbus.api.domain;

public class OrderInfoTripSeat {

    private boolean is_auto_assigned;

    private String label;
    private String deck;
    private String vehicle;
    private String category;

    public boolean isIs_auto_assigned() {
        return is_auto_assigned;
    }

    public void setIs_auto_assigned(boolean is_auto_assigned) {
        this.is_auto_assigned = is_auto_assigned;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

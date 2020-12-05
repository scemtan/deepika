package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class AncillaryOfferCollection {

    private String title;
    private String starting_from_price;
    private String description;

    private List<AncillaryOffer> offers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStarting_from_price() {
        return starting_from_price;
    }

    public void setStarting_from_price(String starting_from_price) {
        this.starting_from_price = starting_from_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AncillaryOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<AncillaryOffer> offers) {
        this.offers = offers;
    }
}

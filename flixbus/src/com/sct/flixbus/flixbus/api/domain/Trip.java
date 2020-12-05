package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class Trip {

    private TripStation from;
    private TripStation to;

    private List<TripItem> items;

    private List<Link> links;

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

    public List<TripItem> getItems() {
        return items;
    }

    public void setItems(List<TripItem> items) {
        this.items = items;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public TripItem getTripItem(int index) {
        return this.items.get(index);
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder()
                .append(this.from.getName()).append(" -> ").append(this.to.getName());

        for (TripItem tripItem : this.getItems()){
            details.append("\n - ")
                    .append("departure: ").append(tripItem.getDeparture().getLocalizedDateTime())
                    .append(" arrival: " ).append(tripItem.getArrival().getLocalizedDateTime())
                    .append(" price: " ).append(tripItem.getPrice_total_sum());
        }

        return details.toString();
    }
}

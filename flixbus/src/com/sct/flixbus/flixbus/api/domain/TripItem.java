package com.sct.flixbus.flixbus.api.domain;

import java.util.ArrayList;
import java.util.List;

public class TripItem {

    private String type;
    private String id;
    private String uid;
    private String status;
    private String transfer_type;
    private String transfer_type_key;
    private String info_title;
    private String info_title_hint;
    private String info_message;
    private String info_message_color;

    private boolean transborder;
    private boolean sale_restriction;

    private int price_total_sum;

    private Discount discount;

    private DateTime departure;
    private DateTime arrival;

    private Duration duration;

    private Availability available;

    private List<Operator> operated_by = new ArrayList<>();

    private List<InterconnectionTransfer> interconnection_transfers = new ArrayList<>();

    private List<Link> links = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Availability getAvailable() {
        return available;
    }

    public void setAvailable(Availability available) {
        this.available = available;
    }

    public List<Operator> getOperated_by() {
        return operated_by;
    }

    public void setOperated_by(List<Operator> operated_by) {
        this.operated_by = operated_by;
    }

    public List<InterconnectionTransfer> getInterconnection_transfers() {
        return interconnection_transfers;
    }

    public void setInterconnection_transfers(List<InterconnectionTransfer> interconnection_transfers) {
        this.interconnection_transfers = interconnection_transfers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTransborder() {
        return transborder;
    }

    public void setTransborder(boolean transborder) {
        this.transborder = transborder;
    }

    public boolean isSale_restriction() {
        return sale_restriction;
    }

    public void setSale_restriction(boolean sale_restriction) {
        this.sale_restriction = sale_restriction;
    }

    public String getTransfer_type() {
        return transfer_type;
    }

    public void setTransfer_type(String transfer_type) {
        this.transfer_type = transfer_type;
    }

    public String getTransfer_type_key() {
        return transfer_type_key;
    }

    public void setTransfer_type_key(String transfer_type_key) {
        this.transfer_type_key = transfer_type_key;
    }

    public int getPrice_total_sum() {
        return price_total_sum;
    }

    public void setPrice_total_sum(int price_total_sum) {
        this.price_total_sum = price_total_sum;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public String getInfo_title() {
        return info_title;
    }

    public void setInfo_title(String info_title) {
        this.info_title = info_title;
    }

    public String getInfo_title_hint() {
        return info_title_hint;
    }

    public void setInfo_title_hint(String info_title_hint) {
        this.info_title_hint = info_title_hint;
    }

    public String getInfo_message() {
        return info_message;
    }

    public void setInfo_message(String info_message) {
        this.info_message = info_message;
    }

    public String getInfo_message_color() {
        return info_message_color;
    }

    public void setInfo_message_color(String info_message_color) {
        this.info_message_color = info_message_color;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

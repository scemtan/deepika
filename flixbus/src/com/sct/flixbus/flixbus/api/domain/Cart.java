package com.sct.flixbus.flixbus.api.domain;

import java.util.List;
import java.util.Map;

public class Cart {

    private boolean more_allowed;
    private boolean is_expired;

    private List<Voucher> vouchers;

    private Map<String, CartItem> items;

    private List<String> messages;

    private CartPrice price;

    private CartReservation reservation;

    private CartExtraProductsExtraItem extra;

    private AncillaryOffers ancillary_offers;

    public boolean isMore_allowed() {
        return more_allowed;
    }

    public void setMore_allowed(boolean more_allowed) {
        this.more_allowed = more_allowed;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<String, CartItem> items) {
        this.items = items;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public CartPrice getPrice() {
        return price;
    }

    public void setPrice(CartPrice price) {
        this.price = price;
    }

    public CartReservation getReservation() {
        return reservation;
    }

    public void setReservation(CartReservation reservation) {
        this.reservation = reservation;
    }

    public boolean isIs_expired() {
        return is_expired;
    }

    public void setIs_expired(boolean is_expired) {
        this.is_expired = is_expired;
    }

    public CartExtraProductsExtraItem getExtra() {
        return extra;
    }

    public void setExtra(CartExtraProductsExtraItem extra) {
        this.extra = extra;
    }

    public AncillaryOffers getAncillary_offers() {
        return ancillary_offers;
    }

    public void setAncillary_offers(AncillaryOffers ancillary_offers) {
        this.ancillary_offers = ancillary_offers;
    }
}

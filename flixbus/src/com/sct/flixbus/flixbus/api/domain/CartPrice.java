package com.sct.flixbus.flixbus.api.domain;

public class CartPrice {

    private int total_tax;
    private int donation;
    private int total;
    private int base_total;
    private int discount;
    private int credit;
    private int subtotal;
    private int subtotal_net;
    private int value;

    private boolean with_donation;
    private boolean with_service_fee;

    private String donation_uid;
    private String service_fee;
    private String mandatory_service_fee;

    public int getTotal_tax() {
        return total_tax;
    }

    public void setTotal_tax(int total_tax) {
        this.total_tax = total_tax;
    }

    public int getDonation() {
        return donation;
    }

    public void setDonation(int donation) {
        this.donation = donation;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBase_total() {
        return base_total;
    }

    public void setBase_total(int base_total) {
        this.base_total = base_total;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getSubtotal_net() {
        return subtotal_net;
    }

    public void setSubtotal_net(int subtotal_net) {
        this.subtotal_net = subtotal_net;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isWith_donation() {
        return with_donation;
    }

    public void setWith_donation(boolean with_donation) {
        this.with_donation = with_donation;
    }

    public boolean isWith_service_fee() {
        return with_service_fee;
    }

    public void setWith_service_fee(boolean with_service_fee) {
        this.with_service_fee = with_service_fee;
    }

    public String getDonation_uid() {
        return donation_uid;
    }

    public void setDonation_uid(String donation_uid) {
        this.donation_uid = donation_uid;
    }

    public String getService_fee() {
        return service_fee;
    }

    public void setService_fee(String service_fee) {
        this.service_fee = service_fee;
    }

    public String getMandatory_service_fee() {
        return mandatory_service_fee;
    }

    public void setMandatory_service_fee(String mandatory_service_fee) {
        this.mandatory_service_fee = mandatory_service_fee;
    }
}

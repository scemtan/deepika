package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class PaymentListResponse {

    private List<Payment> payments;

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}

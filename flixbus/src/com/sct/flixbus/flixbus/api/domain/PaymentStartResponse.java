package com.sct.flixbus.flixbus.api.domain;

public class PaymentStartResponse {

    private boolean result;
    private String payment_id;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }
}

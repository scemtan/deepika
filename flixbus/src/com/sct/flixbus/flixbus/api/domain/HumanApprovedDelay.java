package com.sct.flixbus.flixbus.api.domain;

public class HumanApprovedDelay {

    private String status;
    private String message;

    private DateTime eta;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DateTime getEta() {
        return eta;
    }

    public void setEta(DateTime eta) {
        this.eta = eta;
    }
}

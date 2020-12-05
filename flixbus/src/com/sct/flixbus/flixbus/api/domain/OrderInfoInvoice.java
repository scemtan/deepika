package com.sct.flixbus.flixbus.api.domain;

public class OrderInfoInvoice {

    private String ticket_id;
    private String fiscalization_number;

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getFiscalization_number() {
        return fiscalization_number;
    }

    public void setFiscalization_number(String fiscalization_number) {
        this.fiscalization_number = fiscalization_number;
    }
}

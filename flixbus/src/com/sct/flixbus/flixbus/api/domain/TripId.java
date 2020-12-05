package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class TripId {

    private int id;

    private String uid;
    private String type;
    private String transferTypeKey;

    private List<Operator> operated_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransferTypeKey() {
        return transferTypeKey;
    }

    public void setTransferTypeKey(String transferTypeKey) {
        this.transferTypeKey = transferTypeKey;
    }

    public List<Operator> getOperated_by() {
        return operated_by;
    }

    public void setOperated_by(List<Operator> operated_by) {
        this.operated_by = operated_by;
    }
}

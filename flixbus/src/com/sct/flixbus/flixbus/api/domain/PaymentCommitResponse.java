package com.sct.flixbus.flixbus.api.domain;

public class PaymentCommitResponse {
    private String order_id;
    private String order_uid;
    private String download_hash;

    private boolean result;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_uid() {
        return order_uid;
    }

    public void setOrder_uid(String order_uid) {
        this.order_uid = order_uid;
    }

    public String getDownload_hash() {
        return download_hash;
    }

    public void setDownload_hash(String download_hash) {
        this.download_hash = download_hash;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}

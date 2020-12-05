package com.sct.flixbus.flixbus.api.domain;

public class OrderInfoRequest {
    private final String orderId;
    private final String download_hash;

    public OrderInfoRequest(PaymentCommitResponse paymentCommitResponse) {
        this.orderId       = paymentCommitResponse.getOrder_id();
        this.download_hash = paymentCommitResponse.getDownload_hash();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDownload_hash() {
        return download_hash;
    }
}

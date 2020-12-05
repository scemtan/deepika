package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class OrderInfo {

    private String id;
    private String download_hash;
    private String order_uid;
    private String reminder_link;
    private String qr_data;
    private String qr_image;

    private List<OrderInfoTrip> trips;
    private List<OrderInfoInvoice> invoices;
    private List<InfoBlock> info_blocks;
    private List<OrderInfoAttachment> attachments;
    private List<OrderInfoTax> taxes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDownload_hash() {
        return download_hash;
    }

    public void setDownload_hash(String download_hash) {
        this.download_hash = download_hash;
    }

    public String getOrder_uid() {
        return order_uid;
    }

    public void setOrder_uid(String order_uid) {
        this.order_uid = order_uid;
    }

    public String getReminder_link() {
        return reminder_link;
    }

    public void setReminder_link(String reminder_link) {
        this.reminder_link = reminder_link;
    }

    public String getQr_data() {
        return qr_data;
    }

    public void setQr_data(String qr_data) {
        this.qr_data = qr_data;
    }

    public String getQr_image() {
        return qr_image;
    }

    public void setQr_image(String qr_image) {
        this.qr_image = qr_image;
    }

    public List<OrderInfoTrip> getTrips() {
        return trips;
    }

    public void setTrips(List<OrderInfoTrip> trips) {
        this.trips = trips;
    }

    public List<OrderInfoInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<OrderInfoInvoice> invoices) {
        this.invoices = invoices;
    }

    public List<InfoBlock> getInfo_blocks() {
        return info_blocks;
    }

    public void setInfo_blocks(List<InfoBlock> info_blocks) {
        this.info_blocks = info_blocks;
    }

    public List<OrderInfoAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<OrderInfoAttachment> attachments) {
        this.attachments = attachments;
    }

    public List<OrderInfoTax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<OrderInfoTax> taxes) {
        this.taxes = taxes;
    }
}

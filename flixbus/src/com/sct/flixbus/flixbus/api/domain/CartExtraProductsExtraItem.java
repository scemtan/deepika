package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class CartExtraProductsExtraItem {

    private String title;
    private String description;
    private String product_type;
    private String extra_reference_uid;
    private String price_per_item;
    private String additional_info;
    private String price_template;

    private int count;
    private int max_count;

    private List<CartExtraProductsPassenger> passengers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getExtra_reference_uid() {
        return extra_reference_uid;
    }

    public void setExtra_reference_uid(String extra_reference_uid) {
        this.extra_reference_uid = extra_reference_uid;
    }

    public String getPrice_per_item() {
        return price_per_item;
    }

    public void setPrice_per_item(String price_per_item) {
        this.price_per_item = price_per_item;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    public String getPrice_template() {
        return price_template;
    }

    public void setPrice_template(String price_template) {
        this.price_template = price_template;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMax_count() {
        return max_count;
    }

    public void setMax_count(int max_count) {
        this.max_count = max_count;
    }

    public List<CartExtraProductsPassenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<CartExtraProductsPassenger> passengers) {
        this.passengers = passengers;
    }
}

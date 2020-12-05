package com.sct.flixbus.flixbus.api.domain;

import java.util.List;

public class Payment {
    private String legacy_method;
    private String key;
    private String provider;
    private String method;
    private String title;
    private String description;
    private String customer_message;
    private String disclaimer;
    private String disclaimer_html;
    private String image;

    private boolean internal_test;
    private boolean save_payment_info_allowed;
    private boolean save_payment_info_by_default;
    private boolean only_one_payment_method_can_be_saved;
    private boolean asynchronous;
    private boolean active;
    private boolean email_required;
    private boolean address_required;

    private List<String> payment_service;

    public String getLegacy_method() {
        return legacy_method;
    }

    public void setLegacy_method(String legacy_method) {
        this.legacy_method = legacy_method;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

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

    public String getCustomer_message() {
        return customer_message;
    }

    public void setCustomer_message(String customer_message) {
        this.customer_message = customer_message;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getDisclaimer_html() {
        return disclaimer_html;
    }

    public void setDisclaimer_html(String disclaimer_html) {
        this.disclaimer_html = disclaimer_html;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isInternal_test() {
        return internal_test;
    }

    public void setInternal_test(boolean internal_test) {
        this.internal_test = internal_test;
    }

    public boolean isSave_payment_info_allowed() {
        return save_payment_info_allowed;
    }

    public void setSave_payment_info_allowed(boolean save_payment_info_allowed) {
        this.save_payment_info_allowed = save_payment_info_allowed;
    }

    public boolean isSave_payment_info_by_default() {
        return save_payment_info_by_default;
    }

    public void setSave_payment_info_by_default(boolean save_payment_info_by_default) {
        this.save_payment_info_by_default = save_payment_info_by_default;
    }

    public boolean isOnly_one_payment_method_can_be_saved() {
        return only_one_payment_method_can_be_saved;
    }

    public void setOnly_one_payment_method_can_be_saved(boolean only_one_payment_method_can_be_saved) {
        this.only_one_payment_method_can_be_saved = only_one_payment_method_can_be_saved;
    }

    public boolean isAsynchronous() {
        return asynchronous;
    }

    public void setAsynchronous(boolean asynchronous) {
        this.asynchronous = asynchronous;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isEmail_required() {
        return email_required;
    }

    public void setEmail_required(boolean email_required) {
        this.email_required = email_required;
    }

    public boolean isAddress_required() {
        return address_required;
    }

    public void setAddress_required(boolean address_required) {
        this.address_required = address_required;
    }

    public List<String> getPayment_service() {
        return payment_service;
    }

    public void setPayment_service(List<String> payment_service) {
        this.payment_service = payment_service;
    }
}

package com.sct.flixbus.flixbus.api.domain;

public class OrderInfoTax {

    private double percentage;

    private Country country;

    private Money tax;
    private Money foundation;

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Money getTax() {
        return tax;
    }

    public void setTax(Money tax) {
        this.tax = tax;
    }

    public Money getFoundation() {
        return foundation;
    }

    public void setFoundation(Money foundation) {
        this.foundation = foundation;
    }
}

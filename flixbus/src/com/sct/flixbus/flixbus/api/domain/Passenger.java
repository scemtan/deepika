package com.sct.flixbus.flixbus.api.domain;

public class Passenger {

    private String firstname = "";
    private String lastname = "";
    private String phone = "";
    private String birthdate = "";
    private String patronymic = "";
    private String trip_type = "";
    private String gender = "";
    private String citizenship = "";
    private String identification_type = "";
    private String identification_number = "";
    private String product_type = "";
    private String type = "";
    private String reference_id = "";

    private boolean parental_permission;

    private int passenger_no;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTrip_type() {
        return trip_type;
    }

    public void setTrip_type(String trip_type) {
        this.trip_type = trip_type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getIdentification_type() {
        return identification_type;
    }

    public void setIdentification_type(String identification_type) {
        this.identification_type = identification_type;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReference_id() {
        return reference_id;
    }

    public void setReference_id(String reference_id) {
        this.reference_id = reference_id;
    }

    public boolean isParental_permission() {
        return parental_permission;
    }

    public void setParental_permission(boolean parental_permission) {
        this.parental_permission = parental_permission;
    }

    public int getPassenger_no() {
        return passenger_no;
    }

    public void setPassenger_no(int passenger_no) {
        this.passenger_no = passenger_no;
    }
}

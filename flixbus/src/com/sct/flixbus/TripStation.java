package com.sct.flixbus;

public class TripStation {

    private int id;
    private int importance_order;

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getImportance_order() {
        return importance_order;
    }

    public void setImportance_order(int importance_order) {
        this.importance_order = importance_order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

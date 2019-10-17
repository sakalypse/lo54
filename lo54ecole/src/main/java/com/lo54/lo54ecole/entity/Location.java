package com.lo54.lo54ecole.entity;

import java.io.Serializable;

public class Location implements Serializable {

    private long location_id;
    private String city;

    public Location() {

    }

    public Location(long location_id, String city) {
        this.location_id = location_id;
        this.city = city;
    }

    public long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" + "location_id=" + location_id + ", city=" + city + '}';
    }
}
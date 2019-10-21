package com.lo54.lo54ecole.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LOCATION")
public class Location implements Serializable {

    private long location_id;
    private String city;

    public Location() {

    }

    public Location(String city) {
        this.city = city;
    }

    public Location(long location_id, String city) {
        this.location_id = location_id;
        this.city = city;
    }

    @Id
    @Column(name = "location_id", unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getLocation_id() {
        return location_id;
    }
    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    @Column(name = "city", unique = true)
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
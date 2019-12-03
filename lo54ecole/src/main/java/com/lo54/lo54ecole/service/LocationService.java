package com.lo54.lo54ecole.service;

import com.lo54.lo54ecole.entity.Location;
import com.lo54.lo54ecole.repository.LocationDAO;

import java.util.List;

public class LocationService {
    public Location getLocationByCity(String city){
        LocationDAO locationDAO = new LocationDAO();
        return locationDAO.getByCity(city);
    }

    public List<Location> getAllLocation(){
        LocationDAO locationDAO = new LocationDAO();
        return locationDAO.getAll();
    }

    public void saveLocation(Location location){
        LocationDAO locationDAO = new LocationDAO();
        locationDAO.save(location);
    }

}

package com.lo54.lo54ecole.service;

import com.lo54.lo54ecole.entity.Location;
import com.lo54.lo54ecole.repository.LocationDAO;

public class LocationService {
    public Location getLocationByCity(String city){
        LocationDAO locationDAO = new LocationDAO();
        return locationDAO.GetByCity(city);
    }

    public void saveLocation(Location location){
        LocationDAO locationDAO = new LocationDAO();
        locationDAO.Save(location);
    }

}

package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Location;
import com.launchacademy.reviews.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
  private LocationRepository locationRepository;

  @Autowired
  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public Location findById(Integer id) {
    return locationRepository.findById(id).get();
  }
}

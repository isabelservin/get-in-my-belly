package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Location;
import com.launchacademy.reviews.services.LocationService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationRestApiController {

  private LocationService locationService;

  @Autowired
  public LocationRestApiController(LocationService locationService) {
    this.locationService = locationService;
  }

  @PostMapping
  public ResponseEntity create(@Valid @RequestBody Location location, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
    }
    else {
      return new ResponseEntity<Location>(locationService.save(location), HttpStatus.CREATED);
    }
  }
}

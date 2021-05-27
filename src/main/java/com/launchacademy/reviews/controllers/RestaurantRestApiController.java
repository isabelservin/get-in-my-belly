package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantRestApiController {

  private RestaurantService restaurantService;

  @Autowired
  public RestaurantRestApiController(
      RestaurantService restaurantService) {
    this.restaurantService = restaurantService;
  }

  @GetMapping
  public Page<Restaurant> findAll(Pageable pageable) {
     return  restaurantService.findAll(pageable);
  }


  @PostMapping
  public Restaurant create(@RequestBody Restaurant restaurant) {
    return restaurantService.save(restaurant);
  }


}

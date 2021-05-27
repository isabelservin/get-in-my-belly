package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.services.CategoryService;
import com.launchacademy.reviews.services.RestaurantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

//  @PostMapping
//  public ResponseEntity create(@RequestBody Restaurant restaurant, BindingResult bindingResult) {
//    if(bindingResult.hasErrors()) {
//      return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
//    }
//    else {
//      return new ResponseEntity<Restaurant>(restaurantService.save(restaurant), HttpStatus.CREATED);
//    }
////    return new ResponseEntity(restaurantService.save(restaurant), HttpStatus.OK);
//  }

  @PostMapping
  public Restaurant create(@RequestBody Restaurant restaurant) {
    return restaurantService.save(restaurant);
  }


}

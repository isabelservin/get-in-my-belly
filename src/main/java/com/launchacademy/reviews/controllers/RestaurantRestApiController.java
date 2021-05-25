package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.services.CategoryService;
import com.launchacademy.reviews.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantRestApiController {

  private RestaurantService restaurantService;
  private CategoryService categoryService;

  @Autowired
  public RestaurantRestApiController(
      RestaurantService restaurantService, CategoryService categoryService) {
    this.restaurantService = restaurantService;
    this.categoryService = categoryService;
  }

  @GetMapping
  public Page<Restaurant> findAll(Pageable pageable) {
     return  restaurantService.findAll(pageable);
  }




}

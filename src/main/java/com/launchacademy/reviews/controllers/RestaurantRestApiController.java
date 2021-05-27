package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.services.RestaurantService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

  @GetMapping("/{id}")
  public Restaurant getRestaurantByCategoryNameAndId (@PathVariable Integer id) {
    return restaurantService.findById(id).orElseThrow(() -> new RestaurantNotFound());
  }

  @PostMapping
  public Restaurant create(@RequestBody Restaurant restaurant) {
    return restaurantService.save(restaurant);
  }

  @NoArgsConstructor
  private class RestaurantNotFound extends RuntimeException {};

  @ControllerAdvice
  private class PetTypeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(RestaurantRestApiController.RestaurantNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String petNotFoundHandler(RestaurantRestApiController.RestaurantNotFound ex) {
      return "Can not found what you are looking for";
    }
  }
}

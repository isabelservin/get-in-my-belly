package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.repositories.RestaurantRepository;
import com.launchacademy.reviews.services.CategoryService;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestApiController {
  private CategoryService categoryService;
  @Autowired private RestaurantRepository restaurantRepository;

  @Autowired
  public CategoryRestApiController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/categories")
  public List<Category> displayListCategory() {
    return categoryService.findAll();
  }

  @GetMapping("/{categoryName}")
  public Category getCategory(@PathVariable String categoryName) {
    return categoryService.findCategory(categoryName).orElseThrow(() -> new CategoryNotFound());
  }

  @GetMapping("/{categoryName}/restaurants")
  public List<Restaurant> getRestaurantsByCategory(@PathVariable String categoryName) {
    return categoryService.findCategory(categoryName).orElseThrow(() -> new CategoryNotFound()).getRestaurants();
  }

  @GetMapping("/{categoryName}/restaurant/{id}")
  public Restaurant getRestaurantByCategoryNameAndId (@PathVariable String categoryName, @PathVariable Integer id) {
    return restaurantRepository.findById(id).orElseThrow(() -> new CategoryNotFound());
  }

  @NoArgsConstructor
  private class CategoryNotFound extends RuntimeException {};

  @ControllerAdvice
  private class PetTypeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CategoryNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String petNotFoundHandler(CategoryNotFound ex) {
      return "Can not found what you are looking for";
    }
  }
}

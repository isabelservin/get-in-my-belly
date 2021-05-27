package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.repositories.CategoryRepository;
import com.launchacademy.reviews.repositories.RestaurantRepository;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
  private RestaurantRepository restaurantRepository;
  private CategoryRepository categoryRepository;

  @Autowired
  public RestaurantService(
      RestaurantRepository restaurantRepository, CategoryRepository categoryRepository) {
    this.restaurantRepository = restaurantRepository;
    this.categoryRepository = categoryRepository;
  }

  public Page<Restaurant> findAll(Pageable pageable) {
    return restaurantRepository.findAll(pageable);
  }

  public Optional<Restaurant> findById(Integer id) {
    return restaurantRepository.findById(id);
  }

  public Restaurant save(Restaurant restaurant) {
    Category category = categoryRepository.findByType(restaurant.getCategory().getType());
    restaurant.setCategory(category);
   return restaurantRepository.save(restaurant);
  }
}

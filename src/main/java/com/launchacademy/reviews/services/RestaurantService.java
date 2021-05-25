package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.repositories.RestaurantRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
  private RestaurantRepository restaurantRepository;

  public RestaurantService(
      RestaurantRepository restaurantRepository) {
    this.restaurantRepository = restaurantRepository;
  }

  public Page<Restaurant> findAll(Pageable pageable) {
    return restaurantRepository.findAll(pageable);
  }

  public Optional<Restaurant> findById(Integer id) {
    return restaurantRepository.findById(id);
  }
}

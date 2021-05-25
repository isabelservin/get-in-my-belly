package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.Restaurant;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Integer> {
  public Optional<Restaurant> findByName(String name);

}

package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.repositories.RestaurantRepository;
import com.launchacademy.reviews.repositories.ReviewRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
  private ReviewRepository reviewRepository;
  private RestaurantRepository restaurantRepository;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository,
      RestaurantRepository restaurantRepository) {
    this.reviewRepository = reviewRepository;
    this.restaurantRepository = restaurantRepository;
  }

  public Page<Review> findAll(Pageable pageable) {
    return reviewRepository.findAll(pageable);
  }

  public Review save(Review review) {
    System.out.println(review);
    Optional<Restaurant> current = restaurantRepository.findById(review.getRestaurant().getId());
    review.setRestaurant(current.get());
    return reviewRepository.save(review);
  }

}

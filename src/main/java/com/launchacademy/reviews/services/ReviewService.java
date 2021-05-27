package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Location;
import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.repositories.LocationRepository;
import com.launchacademy.reviews.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
  private ReviewRepository reviewRepository;
  private LocationRepository locationRepository;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository, LocationRepository locationRepository) {
    this.reviewRepository = reviewRepository;
    this.locationRepository = locationRepository;
  }

  public Page<Review> findAll(Pageable pageable) {
    return reviewRepository.findAll(pageable);
  }

  public Review save(Review review) {
    return reviewRepository.save(review);
  }
}

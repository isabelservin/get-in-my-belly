package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewRestApiController {
  private ReviewService reviewService;

  @Autowired
  public ReviewRestApiController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @PostMapping
  public Review create(@RequestBody Review review) {
    return reviewService.save(review);
  }
}

package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.Review;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Integer> {

}

package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocationRepository extends PagingAndSortingRepository<Location, Integer> {

}

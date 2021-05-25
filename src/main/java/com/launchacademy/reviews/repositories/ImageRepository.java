package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {

}

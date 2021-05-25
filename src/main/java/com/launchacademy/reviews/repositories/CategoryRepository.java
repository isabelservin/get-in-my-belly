package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}

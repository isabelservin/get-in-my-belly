package com.launchacademy.reviews.repositories;

import com.launchacademy.reviews.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
  public Category findAllByType(String type);
  Category findByType(String type);
}

package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.repositories.CategoryRepository;
import com.launchacademy.reviews.repositories.RestaurantRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  private CategoryRepository categoryRepository;
  private RestaurantRepository restaurantRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository, RestaurantRepository restaurantRepository) {
    this.categoryRepository = categoryRepository;
    this.restaurantRepository = restaurantRepository;
  }

  public List<Category> findAll() {
    return (List<Category>) categoryRepository.findAll();
  }

  public Optional<Category> findCategory(String categoryName) {
    return Optional.ofNullable(categoryRepository.findAllByType(categoryName));
  }

  public Restaurant getByCategoryAndId (String categoryName, Integer id) {
    Category find = categoryRepository.findAllByType(categoryName);
    return find.getRestaurants().get(id-1);
  }

  public <Optional>Category findByDescription(String description) {
    return categoryRepository.findAllByType(description);
  }
}

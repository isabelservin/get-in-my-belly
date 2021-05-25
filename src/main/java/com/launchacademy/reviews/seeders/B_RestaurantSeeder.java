package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.models.Restaurant;
import com.launchacademy.reviews.repositories.CategoryRepository;
import com.launchacademy.reviews.repositories.RestaurantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class B_RestaurantSeeder implements CommandLineRunner {
  private RestaurantRepository restaurantRepository;
  private CategoryRepository categoryRepository;

   @Autowired
  public B_RestaurantSeeder(
      RestaurantRepository restaurantRepository,
      CategoryRepository categoryRepository) {
    this.restaurantRepository = restaurantRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void run(String...args) throws Exception {
    List<Restaurant> restaurants = (List<Restaurant>) restaurantRepository.findAll();
    List<Category> categories = (List<Category>) categoryRepository.findAll();

    if (restaurants.size() == 0) {
      Restaurant restaurant1 = new Restaurant();
      restaurant1.setCategory(categories.get(0));
      restaurant1.setName("Tamarind Tree");
      restaurant1.setImageUrl("https://s3-media0.fl.yelpcdn.com/bphoto/yhoC1pVnGLrHUu2-8Tcp3A/o.jpg");
      restaurantRepository.save(restaurant1);

      Restaurant restaurant2 = new Restaurant();
      restaurant2.setCategory(categories.get(1));
      restaurant2.setName("Ohana");
      restaurant2.setImageUrl("http://www.ohanasushigrill.com/uploads/7/8/0/6/78067072/editor/img-9531-3.jpg?1588839333");
      restaurantRepository.save(restaurant2);

      Restaurant restaurant3 = new Restaurant();
      restaurant3.setCategory(categories.get(2));
      restaurant3.setName("El Camino");
      restaurant3.setImageUrl("http://elcaminorestaurant.com/wp-content/uploads/2016/04/plantains.jpg");
      restaurantRepository.save(restaurant3);
    }
  }
}

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
      restaurant1.setAddress("1036 S Jackson St, Seattle, WA 98104");
      restaurant1.setPhoneNumber("2068601404");
      restaurant1.setHealthDeptRating(3);
      restaurant1.setDescription("Popular spot for inventive Vietnamese cuisine & cocktails in an elegant, soothing setting.");
      restaurantRepository.save(restaurant1);

      Restaurant restaurant2 = new Restaurant();
      restaurant2.setCategory(categories.get(1));
      restaurant2.setName("Ohana");
      restaurant2.setImageUrl("http://www.ohanasushigrill.com/uploads/7/8/0/6/78067072/editor/img-9531-3.jpg?1588839333");
      restaurant2.setAddress("2207 1st Ave, Seattle, WA 98121");
      restaurant2.setPhoneNumber("2069569329");
      restaurant2.setHealthDeptRating(3);
      restaurant2.setDescription("Hawaiian eats, sushi & tropical cocktails in an upbeat setting with bamboo booths & a tiki bar.");
      restaurantRepository.save(restaurant2);

      Restaurant restaurant3 = new Restaurant();
      restaurant3.setCategory(categories.get(2));
      restaurant3.setName("El Camino");
      restaurant3.setImageUrl("http://elcaminorestaurant.com/wp-content/uploads/2016/04/plantains.jpg");
      restaurant3.setAddress("607 N 35th St, Seattle, WA 98103");
      restaurant3.setPhoneNumber("2066327303");
      restaurant3.setHealthDeptRating(3);
      restaurant3.setDescription("Colorful & lively eatery with creative takes on Mexican regional dishes, washed down by margaritas.");
      restaurantRepository.save(restaurant3);
    }
  }
}

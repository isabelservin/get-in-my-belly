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

      Restaurant restaurant4 = new Restaurant();
      restaurant4.setCategory(categories.get(0));
      restaurant4.setName("Billiard Hoang");
      restaurant4.setImageUrl("https://s3-media0.fl.yelpcdn.com/bphoto/ladn8rUodNr6qHNam-fYZA/o.jpg");
      restaurant4.setAddress("3220 S Hudson St, Seattle, WA 98118");
      restaurant4.setPhoneNumber("2067232054");
      restaurant4.setHealthDeptRating(3);
      restaurant4.setDescription("Unique combination of delicious Vietnamese food and a Billiard Hall.");
      restaurantRepository.save(restaurant4);

      Restaurant restaurant5 = new Restaurant();
      restaurant5.setCategory(categories.get(1));
      restaurant5.setName("Ono Authentic Hawaiian Poke");
      restaurant5.setImageUrl("https://s3-media0.fl.yelpcdn.com/bphoto/2FeLnbSs8qHQmmjDZYMebw/o.jpg");
      restaurant5.setAddress("10016 Edmonds Way Ste E, Edmonds, WA 98020");
      restaurant5.setPhoneNumber("4253617064");
      restaurant5.setHealthDeptRating(3);
      restaurant5.setDescription("Ono grindz. Periodt. Poke, Poke Bowls.  Poke and Poke Bowls are Hawaiian-Style... meaning that it's all about the poke. If you're looking for all the sides, that's not our style. ");
      restaurantRepository.save(restaurant5);

      Restaurant restaurant6 = new Restaurant();
      restaurant6.setCategory(categories.get(2));
      restaurant6.setName("Taqueira El Sabor");
      restaurant6.setImageUrl("https://s3-media0.fl.yelpcdn.com/bphoto/ml3c47G4Dv1tB3dObeqZkg/o.jpg");
      restaurant6.setAddress("15221 Aurora Ave N, Shoreline, WA 98133");
      restaurant6.setPhoneNumber("2064173346");
      restaurant6.setHealthDeptRating(3);
      restaurant6.setDescription("Busy counter-serve Mexican spot featuring fish tacos, burritos & pollo asado amid festive decor.");
      restaurantRepository.save(restaurant6);

      Restaurant restaurant7 = new Restaurant();
      restaurant7.setCategory(categories.get(0));
      restaurant7.setName("Yeh Yeh's");
      restaurant7.setImageUrl("https://s3-media0.fl.yelpcdn.com/bphoto/QvdRAMaWtOtWBdQjjfoylA/o.jpg");
      restaurant7.setAddress("19915 64th Ave W STE 101, Lynnwood, WA 98036");
      restaurant7.setPhoneNumber("4257767213");
      restaurant7.setHealthDeptRating(3);
      restaurant7.setDescription("Counter-serve Vietnamese eatery known for banh mi & beef stew turned out in a bare-bones setting.");
      restaurantRepository.save(restaurant7);

      Restaurant restaurant8 = new Restaurant();
      restaurant8.setCategory(categories.get(1));
      restaurant8.setName("Kono Kitchen");
      restaurant8.setImageUrl("https://s3-media0.fl.yelpcdn.com/bphoto/N36tmF9iAqObIDxp1sv98A/o.jpg");
      restaurant8.setAddress("8501 5th Ave NE, Seattle, 98115");
      restaurant8.setPhoneNumber("2065175662");
      restaurant8.setHealthDeptRating(3);
      restaurant8.setDescription("A casual family dining experience where you’ll find a tempting array of Hawaiian and Japanese dishes prepared with the care of a home-cooked meal.");
      restaurantRepository.save(restaurant8);

      Restaurant restaurant9 = new Restaurant();
      restaurant9.setCategory(categories.get(2));
      restaurant9.setName("Las Espuelas");
      restaurant9.setImageUrl("https://s3-media0.fl.yelpcdn.com/bphoto/WI7lPcVGP_xxU0TOYwiKlA/o.jpg");
      restaurant9.setAddress("4306 228th St SW #9, Mountlake Terrace, WA 98043");
      restaurant9.setPhoneNumber("4254095070");
      restaurant9.setHealthDeptRating(3);
      restaurant9.setDescription("Familiar Mexican platters, plus draft beer & margaritas, in a casual, Western-themed restaurant.");
      restaurantRepository.save(restaurant9);
    }
  }
}

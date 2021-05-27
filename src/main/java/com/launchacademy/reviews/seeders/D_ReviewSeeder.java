package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Review;
import com.launchacademy.reviews.repositories.RestaurantRepository;
import com.launchacademy.reviews.repositories.ReviewRepository;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class D_ReviewSeeder implements CommandLineRunner {
  private ReviewRepository reviewRepository;
  private RestaurantRepository restaurantRepository;

  @Autowired
  public D_ReviewSeeder(ReviewRepository reviewRepository,
      RestaurantRepository restaurantRepository) {
    this.reviewRepository = reviewRepository;
    this.restaurantRepository = restaurantRepository;
  }


  @Override
  public void run(String...args) throws Exception {
    List<Review> reviews = (List<Review>) reviewRepository.findAll();

    if (reviews.size() == 0) {
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      Review review1 = new Review();
      review1.setReview("We loved this restaurant. Wonderful atmosphere and great food. Our waitress was exceptional and helped us so much with our choices. Egg rolls were the best we’ve ever had and main dishes were so good. Cannot wait to return.");
      review1.setRestaurant(restaurantRepository.findByName("Tamarind Tree").get());
      review1.setRestaurantRating(5);
      review1.setDatePosted(timestamp);
      reviewRepository.save(review1);

      Review review2 = new Review();
      review2.setReview("They have amazing drinks. Their mule with the spiced rum is out of the world. The ginger chicken and the bento box was good as well. Make sure to make a reservation otherwise you are not getting in.");
      review2.setRestaurant(restaurantRepository.findByName("Ohana").get());
      review2.setRestaurantRating(5);
      review2.setDatePosted(timestamp);
      reviewRepository.save(review2);

      Review review3 = new Review();
      review3.setReview("I really like this place. The service was great. The food is a bit expensive for what you get. We got enchiladas ($16) which I'm used to filling up the plate but we only got two little guys about 5 inches long. They were delicious though and the smaller portion was perfect for one. I wish they were doing happy hour but I understand not doing it during COVID. Outdoor seating was great.");
      review3.setRestaurant(restaurantRepository.findByName("El Camino").get());
      review3.setRestaurantRating(4);
      review3.setDatePosted(timestamp);
      reviewRepository.save(review3);
    }

  }
}

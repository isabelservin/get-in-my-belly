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

      Review review4 = new Review();
      review4.setReview("Wow. A place where you can get amazing banh mis AND play billiards? Unheard of. Highly recommend.");
      review4.setRestaurant(restaurantRepository.findByName("Billiard Hoang").get());
      review4.setRestaurantRating(4);
      review4.setDatePosted(timestamp);
      reviewRepository.save(review4);

      Review review5 = new Review();
      review5.setReview("I thought that when I got my heart broken that the wound felt really raw. But, this place has the freshest, most raw-est cuts of poke you can find beyond the islands. I couldn't believe I got so lucky. I needed a cure for my broken heart, and I am so glad I came across Ono Poke after a long journey through a terrible relationship. Stay single!");
      review5.setRestaurant(restaurantRepository.findByName("Ono Authentic Hawaiian Poke").get());
      review5.setRestaurantRating(4);
      review5.setDatePosted(timestamp);
      reviewRepository.save(review5);

      Review review6 = new Review();
      review6.setReview("This might sound a little wild, but I got my all four of my wisdom teeth extracted and my family decided to come here after my procedure. I was in agony. Unable to eat. This place made everything look so good. I don't know whether it was because I was just coming out of anesthesia, or they really knew what there were doing and throwing it down in the kitchen. Nonetheless, I would come here again--I didn't eat here--but my family says I gotta try it after my extraction sites heal.");
      review6.setRestaurant(restaurantRepository.findByName("Taqueira El Sabor").get());
      review6.setRestaurantRating(4);
      review6.setDatePosted(timestamp);
      reviewRepository.save(review6);

      Review review7 = new Review();
      review7.setReview("Hands down the best banh mi shop. Something about the way they marinate their meat just gets to me. It provides me with crackhead energy thus making me the great person that I am today. I couldn't imagine my life without stumbling here after my finals for school. 100/10 I would recommend.");
      review7.setRestaurant(restaurantRepository.findByName("Yeh Yeh's").get());
      review7.setRestaurantRating(4);
      review7.setDatePosted(timestamp);
      reviewRepository.save(review7);

      Review review8 = new Review();
      review8.setReview("Kona Kitchen's mac salad > everywhere else. I don't know what it is, my life get pieced back together every time I get the chance to indulge in their mac salad. I want to say I am a regular here. I am a 'regular' if I come back every day, right? Anyways, these hawaiian plates are sooooo good! The portions are amazing. I come here as often as I can because I don't have family and they treat me like one. Helps the void in my heart.");
      review8.setRestaurant(restaurantRepository.findByName("Kono Kitchen").get());
      review8.setRestaurantRating(4);
      review8.setDatePosted(timestamp);
      reviewRepository.save(review8);

      Review review9 = new Review();
      review9.setReview("I wasn't going to admit this, but I am in too deep not to admit it. I came to Las Espuelas for my older coworker's birthday party. I just turned 21 and my older coworkers are out of my league. They ordered this fish-bowl sized Margarita... next thing you know, they are telling me their life stories and those classic 'back when I was a kid' kind of stories. It was a little awkward since I was their DD. But! You know what, I was in for a great time with these ancient humans. And, Las Espuelas has the B E S T salsa, plates, drinks. You name it, they got it. They're always super packed, so plan accordingly.");
      review9.setRestaurant(restaurantRepository.findByName("Las Espuelas").get());
      review9.setRestaurantRating(4);
      review9.setDatePosted(timestamp);
      reviewRepository.save(review9);
    }

  }
}

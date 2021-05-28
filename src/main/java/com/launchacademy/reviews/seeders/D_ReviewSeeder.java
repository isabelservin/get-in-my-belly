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
      review3.setRestaurantRating(5);
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
      review5.setRestaurant(restaurantRepository.findByName("Ono Poke").get());
      review5.setRestaurantRating(4);
      review5.setDatePosted(timestamp);
      reviewRepository.save(review5);

      Review review6 = new Review();
      review6.setReview("This might sound a little wild, but I got my all four of my wisdom teeth extracted and my family decided to come here after my procedure. I was in agony. Unable to eat. This place made everything look so good. I don't know whether it was because I was just coming out of anesthesia, or they really knew what there were doing and throwing it down in the kitchen. Nonetheless, I would come here again--I didn't eat here--but my family says I gotta try it after my extraction sites heal.");
      review6.setRestaurant(restaurantRepository.findByName("Taqueira El Sabor").get());
      review6.setRestaurantRating(5);
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
      review8.setRestaurant(restaurantRepository.findByName("Kona Kitchen").get());
      review8.setRestaurantRating(4);
      review8.setDatePosted(timestamp);
      reviewRepository.save(review8);

      Review review9 = new Review();
      review9.setReview("I wasn't going to admit this, but I am in too deep not to admit it. I came to Las Espuelas for my older coworker's birthday party. I just turned 21 and my older coworkers are out of my league. They ordered this fish-bowl sized Margarita... next thing you know, they are telling me their life stories and those classic 'back when I was a kid' kind of stories. It was a little awkward since I was their DD. But! You know what, I was in for a great time with these ancient humans. And, Las Espuelas has the B E S T salsa, plates, drinks. You name it, they got it. They're always super packed, so plan accordingly.");
      review9.setRestaurant(restaurantRepository.findByName("Las Espuelas").get());
      review9.setRestaurantRating(4);
      review9.setDatePosted(timestamp);
      reviewRepository.save(review9);

      Review tamReview = new Review();
      tamReview.setReview("Tamarind Tree is a locally owned Vietnamese restaurant known for their extremely large menu and good portion for price. Their parking lot is a little tough to get in and out of but don't let that scare you away. The service is great here, the food is delicious and the prices are really manageable. I would highly recommend coming here for lunch or dinner, and their outdoor seating area is pretty sweet. The chili chicken lemon leaves is delicious and you can't go wrong with their version of the vermicelli bowl.");
      tamReview.setRestaurant(restaurantRepository.findByName("Tamarind Tree").get());
      tamReview.setRestaurantRating(5);
      tamReview.setDatePosted(timestamp);
      reviewRepository.save(tamReview);

      Review tamReview1 = new Review();
      tamReview1.setReview("Best Vietnamese restaurant in Seattle. The menu is a mile long and you can't go wrong. The egg rolls, veggie or pork, are phenomenal. Their pho is amazing and priced like any other pho place in town. Tamarind tree traditional rice is a go to for me. They have a variety of meat dishes, everything from duck to ground shrimp, which is better than it sounds. Also a ton of veg options. The staff are always very friendly and the pandemic has upped their outdoor seating game and their takeout operation if you prefer to eat at home.");
      tamReview1.setRestaurant(restaurantRepository.findByName("Tamarind Tree").get());
      tamReview1.setRestaurantRating(5);
      tamReview1.setDatePosted(timestamp);
      reviewRepository.save(tamReview1);

      Review tamReview2 = new Review();
      tamReview2.setReview("This is one of the best restaurants in Seattle, it is also hands down one of the best Vietnamese restaurants I've ever eaten at around the world. The shrimp sugar cane is incredible, as is the pork cinnamon green rice meat balls. Just a flavor that is outstanding. The lychee martinis are an absolute must as well, perfectly mixed. Seattle isn't extremely well known for its food, but this is a pure gem.");
      tamReview2.setRestaurant(restaurantRepository.findByName("Tamarind Tree").get());
      tamReview2.setRestaurantRating(5);
      tamReview2.setDatePosted(timestamp);
      reviewRepository.save(tamReview2);

      Review ohana1 = new Review();
      ohana1.setReview("Amazing place for Hawaiian and Japanese food. The whole feel of the place is like one is on a beach vacay. We ordered tempura platter, crunchy roll and chicken katsu..it was yummy! They have live music/dj at nights. We went for lunch and it was transformed into a tranquil space");
      ohana1.setRestaurant(restaurantRepository.findByName("Ohana").get());
      ohana1.setRestaurantRating(5);
      ohana1.setDatePosted(timestamp);
      reviewRepository.save(ohana1);

      Review ohana2 = new Review();
      ohana2.setReview("Friendly and accommodating service and good food.   This was the perfect place to come with our tween kids. Lots of variety on the menu - Hawaiian favorites like Kahlua pork and poke, but also some great additions like adobo chicken. Also their Happy Hour menu had lots of sushi!!");
      ohana2.setRestaurant(restaurantRepository.findByName("Ohana").get());
      ohana2.setRestaurantRating(5);
      ohana2.setDatePosted(timestamp);
      reviewRepository.save(ohana2);

      Review ohana3 = new Review();
      ohana3.setReview("They have amazing drinks. Their mule with the spiced rum is out of the world. The ginger chicken and the bento box was good as well. Make sure to make a reservation otherwise you are not getting in.");
      ohana3.setRestaurant(restaurantRepository.findByName("Ohana").get());
      ohana3.setRestaurantRating(5);
      ohana3.setDatePosted(timestamp);
      reviewRepository.save(ohana3);

      Review camino1 = new Review();
      camino1.setReview("Best mexican restaurant! It's themed but not over done. The staff are so nice and extra careful with covid guidelines. There's always water on the table and the tequila is smooth. Food is the highlight for me though. I really appreciate the fresh vegetables in the vegetarian dish I had and the more elaborate options I had here than just beans and cheese. Will come again!");
      camino1.setRestaurant(restaurantRepository.findByName("El Camino").get());
      camino1.setRestaurantRating(5);
      camino1.setDatePosted(timestamp);
      reviewRepository.save(camino1);

      Review camino2 = new Review();
      camino2.setReview("This is probably one of the best places to dine in a pandemic. They have lots of outdoor seating including private tents with heaters and all the staff are wearing masks. Just put your name in online and come through. The food is really good, I’ve had both the chicken burrito and the tortilla soup and both were great!");
      camino2.setRestaurant(restaurantRepository.findByName("El Camino").get());
      camino2.setRestaurantRating(4);
      camino2.setDatePosted(timestamp);
      reviewRepository.save(camino2);

      Review camino3 = new Review();
      camino3.setReview("The food is PHENOMENAL here! Where to begin; the salsa, you could taste the flavors of the peppers without it being too spicy. Our entrees were literally making our tastebuds dance in our mouths! The carnitas were tender and juicy with fresh cut toppings. The poblano pepper and cheese burrito hands down HUGELY stuffed goodness! There was so much flavor in our dinner we couldn't choose which we liked the best because it was all such great food! Drinks were great! Atmosphere was fun and done with the right touches to focus on the best part about El Camino; THE FOOD!");
      camino3.setRestaurant(restaurantRepository.findByName("El Camino").get());
      camino3.setRestaurantRating(5);
      camino3.setDatePosted(timestamp);
      reviewRepository.save(camino3);

      Review billiard1 = new Review();
      billiard1.setReview("Food review only - Best egg banh mi EVER!!!  I'm in love.  I go again and again.  And then again at 3am if I crave a late night snack.  Actually, all of their food is good.  You can do no wrong here.  Just close your eyes and point to an item on the menu and you won't be disappointed.  As long as their chef doesn't change, they've got themselves a lifetime customer.");
      billiard1.setRestaurant(restaurantRepository.findByName("Billiard Hoang").get());
      billiard1.setRestaurantRating(5);
      billiard1.setDatePosted(timestamp);
      reviewRepository.save(billiard1);

      Review billiard2 = new Review();
      billiard2.setReview("I give Billiard Hoang 5 stars because this place is truly a hole in the wall. Billiard Hoang is best known for their delicious Vietnamese sandwich with a fried egg (best in Seattle if you ask me--yes, better than Yeh Yeh and way better than all the bakeries near by). Location is very sketchy and it is highly recommended to go with someone Vietnamese or a regular.");
      billiard2.setRestaurant(restaurantRepository.findByName("Billiard Hoang").get());
      billiard2.setRestaurantRating(5);
      billiard2.setDatePosted(timestamp);
      reviewRepository.save(billiard2);

      Review billiard3 = new Review();
      billiard3.setReview("You don't come to this place for the ambiance - just for the food - after all it is a pool hall. That aside I think this place makes great food! I recommend the Spam & Egg sandwich. This isn't just your regular spam though. I think they use some kind of asian spam cause it definitely taste a little sweeter than the usual. The egg is a slightly scrambled. The sandwich contains a bit of soy sauce. hot sauce, and onions. And best of all its still under $3!");
      billiard3.setRestaurant(restaurantRepository.findByName("Billiard Hoang").get());
      billiard3.setRestaurantRating(4);
      billiard3.setDatePosted(timestamp);
      reviewRepository.save(billiard3);

      Review ono1 = new Review();
      ono1.setReview("Anytime I'm in Edmonds, I have to stop by Ono Poke. Their Poke is so fresh and simple and they always have different poke every time I come, so I have to try them all. Whenever I go here, I always pick up a poke bowl with two choices. One of the choices is usually one of their different flavored ahi and the other can be anything from their spicy salmon, crab okole, tako, hamachi or anything I feel like. Also, make sure you don't forget the sides. I'm in love with their spicy Kimchee cucumber as well as their Mac Salad. I'm a sucker for Mac Salad and they do it well here. If you're an edamame fan, you might as well add that too. Ono Poke just has that relaxed feel. Even with the pandemic, they keep it very safe, clean, and organized for the customers, but they still keep that welcoming feel. The owners and staff here treat you like they've known you for decades and you can tell customers keep coming back. This is one of my favorite spots in town and I always love coming here.");
      ono1.setRestaurant(restaurantRepository.findByName("Ono Poke").get());
      ono1.setRestaurantRating(5);
      ono1.setDatePosted(timestamp);
      reviewRepository.save(ono1);

      Review ono2 = new Review();
      ono2.setReview("First off, I am very picky with raw fish. If the texture isn't perfect I just can't do it. The scallops were too squishy for me but my husband loved it. So that's just me. The spicy tuna was amazing! It literally has the perfect mouthfeel. They have their poke skills down here! Keep in mind this is Hawaiian style so different from other poke places but I loved it! The cucumber kimchi was fire! Literally lol, it was really spicy but worth every bite! Now I need to come back to try every item! My husband loves poke so I know this will be a place we return! Give them a try! They do Hawaiian poke right!");
      ono2.setRestaurant(restaurantRepository.findByName("Ono Poke").get());
      ono2.setRestaurantRating(4);
      ono2.setDatePosted(timestamp);
      reviewRepository.save(ono2);

      Review ono3 = new Review();
      ono3.setReview("Best POKE in Washington. Simply because of the authenticity in the way they serve there POKE. Its like getting it from Food land In Hawaii. The common Poke here in WA has a lot of color and toppings and all but that is just not what Poke is. Usually there isn't a lot of toppings and all this stuff in Poke.  Nothing to fancy just the Poke and rice. A good amount of Poke and there seasoning and flavoring is very Yummy. I suggest there spicy Hamachi and Spicy Salmon if you can handle a little spice. Very very good Poke");
      ono3.setRestaurant(restaurantRepository.findByName("Ono Poke").get());
      ono3.setRestaurantRating(5);
      ono3.setDatePosted(timestamp);
      reviewRepository.save(ono3);

      Review taqueria1 = new Review();
      taqueria1.setReview("Such incredible food! This is the most authentic Taqueria I've experienced since living in Texas. They're also super friendly. If you're adventurous, try some lengua! It's my favorite. But really, you can't go wrong with anything on their menu.");
      taqueria1.setRestaurant(restaurantRepository.findByName("Taqueira El Sabor").get());
      taqueria1.setRestaurantRating(4);
      taqueria1.setDatePosted(timestamp);
      reviewRepository.save(taqueria1);

      Review taqueria2 = new Review();
      taqueria2.setReview("I was nearby and dire need of something quick to eat. I do not regret this decision one bit! I ordered veggie gorditas and they were very good and well filled! There is a salsa bar of lots of options for you to choose from. I wish they had signs on spice level for each because I was unsure which ones I was picking.");
      taqueria2.setRestaurant(restaurantRepository.findByName("Taqueira El Sabor").get());
      taqueria2.setRestaurantRating(5);
      taqueria2.setDatePosted(timestamp);
      reviewRepository.save(taqueria2);

      Review taqueria3 = new Review();
      taqueria3.setReview("First time in and I really enjoyed the couple things I had the honor of devouring. I ordered the birria which had a pretty strong spiced and  semi oily broth with a tiny bit of heat.  The bowl of stewed meat really hit the spot in this cold rainy night.  Wasn't sure what meat it was made of, prob beef, maybe mutton, whatever it is, it's good! The order came with a few tortillas, rice & beans, and nice pile of diced onions and chopped cilantro (which really helps cut the richness). I also had one carnita street taco which was pretty good as well...not birria good though.  Also, aside from  good pricing, the cherry on top is the drink that comes with your meal.  How can you beat that?!");
      taqueria3.setRestaurant(restaurantRepository.findByName("Taqueira El Sabor").get());
      taqueria3.setRestaurantRating(4);
      taqueria3.setDatePosted(timestamp);
      reviewRepository.save(taqueria3);

      Review hani1 = new Review();
      hani1.setReview("Found this place on a whim when we’re craving for Poke Bowls on the way home to Seattle from Everett. The neighborhood was very dark and too quiet, we thought we were lost. But the Poke here is so rewarding! Great price and we can decide whichever proteins and toppings we want. Tasted awesome and fresh, too. We ended up ordering an extra to go.");
      hani1.setRestaurant(restaurantRepository.findByName("Hani Hani").get());
      hani1.setRestaurantRating(5);
      hani1.setDatePosted(timestamp);
      reviewRepository.save(hani1);

      Review hani2 = new Review();
      hani2.setReview("Great little spot but a little hard to spot northbound. Inside is nothing fancy, but adequate space with tables and bar seating. Food was excellent and the price was reasonable. I ordered a geisha bowl and tempura appetizer. I recommend this restraunt.");
      hani2.setRestaurant(restaurantRepository.findByName("Hani Hani").get());
      hani2.setRestaurantRating(4);
      hani2.setDatePosted(timestamp);
      reviewRepository.save(hani2);

      Review hani3 = new Review();
      hani3.setReview("Awesome shop! We got the chicken katsu with fried rice and mac salad as well as the BBQ chicken and some Sspam Musabi. Everything was flavorful and hit the spot. I'm excited to try some of their other offerings next time.");
      hani3.setRestaurant(restaurantRepository.findByName("Hani Hani").get());
      hani3.setRestaurantRating(5);
      hani3.setDatePosted(timestamp);
      reviewRepository.save(hani3);

      Review moctezuma1 = new Review();
      moctezuma1.setReview("The ambiance here is amazing for a great date night. We were fortunate enough to sit by the indoor fireplace. We shared the enchilada platter and a chicken with shrimp molcajete. The enchiladas were fresh and my favorite was the Chile verde one with chicken. The meat was well seasoned and the sauces were flavorful and unique. Definitely not like the typical Tex mex I'm used to. The molcajete came out piping hot as expected and has plenty of meat inside. It came with tortillas and salsa with guac but we put it on tortilla chips instead. Highly recommend and can't wait to return.");
      moctezuma1.setRestaurant(restaurantRepository.findByName("Moctezuma's").get());
      moctezuma1.setRestaurantRating(4);
      moctezuma1.setDatePosted(timestamp);
      reviewRepository.save(moctezuma1);

      Review moctezuma2 = new Review();
      moctezuma2.setReview("Great restaurant ! Grateful! They are open during this time ! Service was very friendly. A few things messed up with our food, but it was quickly fixed. Their queso fondito was amazing, especially with the chorizo! Their chille rellenos are great too although I wish the cheese was melted more inside. Their carne asada is so flavorful. My favorite thing of all is their chips and salsa. Love this place !");
      moctezuma2.setRestaurant(restaurantRepository.findByName("Moctezuma's").get());
      moctezuma2.setRestaurantRating(5);
      moctezuma2.setDatePosted(timestamp);
      reviewRepository.save(moctezuma2);

      Review moctezuma3 = new Review();
      moctezuma3.setReview("The real and only reason why I come here is for the flights! The margarita flight is so good and a perfect amount to pair with your meal! I, again, mostly come here for drinks. But food is good in size! There's not much that stands out to me in terms of service. I love that it in conveniently located at Southcenter. Outdoor seating is available but super limited.");
      moctezuma3.setRestaurant(restaurantRepository.findByName("Moctezuma's").get());
      moctezuma3.setRestaurantRating(4);
      moctezuma3.setDatePosted(timestamp);
      reviewRepository.save(moctezuma3);

      Review cocinaOaxaqueña1 = new Review();
      cocinaOaxaqueña1.setReview("Homemade tortilla for the quesadilla was a huge win with my little guy! The food and service overall was great! The pitcher of Sangria was so delicious, both my husband and I enjoyed it. It was the perfect dinner for our last night in Seattle.");
      cocinaOaxaqueña1.setRestaurant(restaurantRepository.findByName("La Cocina Oaxaqueña").get());
      cocinaOaxaqueña1.setRestaurantRating(5);
      cocinaOaxaqueña1.setDatePosted(timestamp);
      reviewRepository.save(cocinaOaxaqueña1);

      Review cocinaOaxaqueña2 = new Review();
      cocinaOaxaqueña2.setReview("Really delicious food! My tacos were filled with flavor, as was my partner's carne asada. We've only gotten pickup during the pandemic, but I look forward to the day I can go sit down here for drinks since the location is amazing. I'm excited to order from here again!");
      cocinaOaxaqueña2.setRestaurant(restaurantRepository.findByName("La Cocina Oaxaqueña").get());
      cocinaOaxaqueña2.setRestaurantRating(4);
      cocinaOaxaqueña2.setDatePosted(timestamp);
      reviewRepository.save(cocinaOaxaqueña2);

      Review cocinaOaxaqueña3 = new Review();
      cocinaOaxaqueña3.setReview("This is one of my favorites Mexican restaurants around Seattle. Everything looks super fresh and delicious. The plates have a perfect size no too big no too small, and there isn’t nothing to complain about the prices.");
      cocinaOaxaqueña3.setRestaurant(restaurantRepository.findByName("La Cocina Oaxaqueña").get());
      cocinaOaxaqueña3.setRestaurantRating(5);
      cocinaOaxaqueña3.setDatePosted(timestamp);
      reviewRepository.save(cocinaOaxaqueña3);

      Review phoHouse1 = new Review();
      phoHouse1.setReview("This place has the best pho and the NICEST employees. The egg rolls were hot & crispy with a yummy meat and noodle filling, the pho was outstanding and both came out in record time. At first we were confused where the sriracha was because we only saw a little container of hoisin sauce and one of the servers overheard us so she came rushing down asking if we needed extra sriracha - turns out it was in the same container!");
      phoHouse1.setRestaurant(restaurantRepository.findByName("Pho Nguyen’s House").get());
      phoHouse1.setRestaurantRating(4);
      phoHouse1.setDatePosted(timestamp);
      reviewRepository.save(phoHouse1);

      Review phoHouse2 = new Review();
      phoHouse2.setReview("Ordered for pick up and the pho was packaged nicely in a paper bowl, which I thought was great and looked very presentable. The soup broth wasn't overly oily or salty and that is a big plus. Definitely order the shrimp spring rolls!!");
      phoHouse2.setRestaurant(restaurantRepository.findByName("Pho Nguyen’s House").get());
      phoHouse2.setRestaurantRating(4);
      phoHouse2.setDatePosted(timestamp);
      reviewRepository.save(phoHouse2);

      Review phoHouse3 = new Review();
      phoHouse3.setReview("Their food is amazing!! The cook in the back I've been following him for about 5 yrs now. The pho is exceptional! The rice plate is amazing without the sauce! Def our new fav spot and the staff is friendly and efficient!");
      phoHouse3.setRestaurant(restaurantRepository.findByName("Pho Nguyen’s House").get());
      phoHouse3.setRestaurantRating(5);
      phoHouse3.setDatePosted(timestamp);
      reviewRepository.save(phoHouse3);

      Review marination1 = new Review();
      marination1.setReview("My favorite place to go on a sunny day during non-covid times. But even getting take-out during covid, which I was not sure about, worked out great. Their tacos are soo good, definitely some of the best I've had and the mac salad and kimchee fried rice is amazing. I don't even like Kimchee but I love the fried rice (my husband loves kimchee, and also loves it, so it's not subject to your love or hate of kimchee, it's just amazing.)");
      marination1.setRestaurant(restaurantRepository.findByName("Marination Ma Kai").get());
      marination1.setRestaurantRating(4);
      marination1.setDatePosted(timestamp);
      reviewRepository.save(marination1);

      Review marination2 = new Review();
      marination2.setReview("Comfort food in colors and textures that are surprising, but balanced and delicious. Add to that a spacious waterside patio with a postcard-worthy view to downtown Seattle. Please go. I wish I lived closer.");
      marination2.setRestaurant(restaurantRepository.findByName("Marination Ma Kai").get());
      marination2.setRestaurantRating(5);
      marination2.setDatePosted(timestamp);
      reviewRepository.save(marination2);

      Review marination3 = new Review();
      marination3.setReview("Long line but worth it! We were very impressed with the safety precautions taken place at Ma Kai. The food was so good that we forgot to take pictures before chowing down everything. If you miss authentic Hawaiian food, this is the place to go to! We will be back.");
      marination3.setRestaurant(restaurantRepository.findByName("Marination Ma Kai").get());
      marination3.setRestaurantRating(4);
      marination3.setDatePosted(timestamp);
      reviewRepository.save(marination3);

      Review marination4 = new Review();
      marination4.setReview("Needed to try the fish and chips. Was told it was one of the best in Seattle. I can truly say the breeding is so crispy and the fish itself is very very juicy. You get 2 pieces. The tarter sauce is just right, it gives it that extra kick with a squirt of lemon. The fries on there own are great. There saltines is just perfeft and gives a balance to the whole meal. Will definitely be back.");
      marination4.setRestaurant(restaurantRepository.findByName("Marination Ma Kai").get());
      marination4.setRestaurantRating(5);
      marination4.setDatePosted(timestamp);
      reviewRepository.save(marination4);

      Review tijuana1 = new Review();
      tijuana1.setReview("This place is a hidden gem if you're craving thus type of food! Even though I personally like their veggie burrito because it comes with lots of different grilled veggies, some other people may not so I'm not suggesting this place for vegetarians. You come here for the tacos, soup, and churros. They're always super nice too.");
      tijuana1.setRestaurant(restaurantRepository.findByName("Tijuana Restaurant").get());
      tijuana1.setRestaurantRating(4);
      tijuana1.setDatePosted(timestamp);
      reviewRepository.save(tijuana1);

      Review tijuana2 = new Review();
      tijuana2.setReview("Cheesy tacos--need I say more? But seriously, these are not your average tacos!! They sent my taste buds to another dimension that was filled with happiness. Get the soup/dip too...you won't be disappointed! Very tasty!!");
      tijuana2.setRestaurant(restaurantRepository.findByName("Tijuana Restaurant").get());
      tijuana2.setRestaurantRating(4);
      tijuana2.setDatePosted(timestamp);
      reviewRepository.save(tijuana2);

      Review tijuana3 = new Review();
      tijuana3.setReview("I love tacos and this might be my new favorite place to visit when I have a craving. The tacos might be a bit pricey but well worth it for what you get. In the age of COVID I was happy to see that everyone was wearing a mask and social distancing which made it even better.");
      tijuana3.setRestaurant(restaurantRepository.findByName("Tijuana Restaurant").get());
      tijuana3.setRestaurantRating(5);
      tijuana3.setDatePosted(timestamp);
      reviewRepository.save(tijuana3);

      Review yehyeh1 = new Review();
      yehyeh1.setReview("Crazy fast service and they apologized for not being crazy faster ! This was our first trip here and when I took my first bite I went caw caww! because the flavor tickled at my heart. Got taro bubble tea and the boba tastes like a cloud - which is a good thing. Now I've befriended the ravens. Thanks guys ! Cons were that the parking lot is shaped like a pretzel and our car is not that edible. This is not to say that the parking lot is confusing- just that it may look like it should be confusing.");
      yehyeh1.setRestaurant(restaurantRepository.findByName("Yeh Yeh's").get());
      yehyeh1.setRestaurantRating(4);
      yehyeh1.setDatePosted(timestamp);
      reviewRepository.save(yehyeh1);

      Review yehyeh2 = new Review();
      yehyeh2.setReview("I live in North Seattle and I never think twice about driving up further north for One of the Best Bahn Mi Sandwiches around and for their Full-flavored Beef Broth Pho, which is also some of the best Pho I've had in the area. This place is definitely worth the trip! So do yourselves a big favor and eat here.");
      yehyeh2.setRestaurant(restaurantRepository.findByName("Yeh Yeh's").get());
      yehyeh2.setRestaurantRating(5);
      yehyeh2.setDatePosted(timestamp);
      reviewRepository.save(yehyeh2);

      Review yehyeh3 = new Review();
      yehyeh3.setReview("The pork banh mi and the vietnamese beef stew is legit. Parking is tight around this place. Order online beforehand if you can. There is a mom and pop grocery store next to it which has interesting middle eastern and eastern european stuff! Show them some love while you wait for you food.");
      yehyeh3.setRestaurant(restaurantRepository.findByName("Yeh Yeh's").get());
      yehyeh3.setRestaurantRating(4);
      yehyeh3.setDatePosted(timestamp);
      reviewRepository.save(yehyeh3);

      Review yehyeh4 = new Review();
      yehyeh4.setReview("I have been eating there for years!  Best food in Edmonds for the price...my favorite is the beef stew with noodles...and a half sandwich with chicken or pork. You will not be able to eat it all at one time....unless you are x-tra hungry.");
      yehyeh4.setRestaurant(restaurantRepository.findByName("Yeh Yeh's").get());
      yehyeh4.setRestaurantRating(4);
      yehyeh4.setDatePosted(timestamp);
      reviewRepository.save(yehyeh4);

      Review espuelas1 = new Review();
      espuelas1.setReview("Came to this place because my wife and I felt like having Mexican food. We hadn't been to a Mexican restaurant in over 4 months because we make our own food. This place caught our eye because of the name so we figured we'd try it out. As soon as we walked in you can see the cleanliness of the place and smell the food. People were very kind and got us seated right away. Not a huge menu and that's what I like. If you've got a big menu then you have to say to yourself that they ain't making all that stuff from scratch. Our experience was an excellent one as the server was always checking to see if we needed anything and was very prompt with our requests. Food was delicious!  I know I ordered enchiladas, which is pretty plain for a Mexican restaurant, but the flavor was perfect especially with that salsa verde. Chips and salsa was good and also came with a pico de gallo that had nopales (cactus). I would go back to this place just because. Highly recommend it.");
      espuelas1.setRestaurant(restaurantRepository.findByName("Las Espuelas").get());
      espuelas1.setRestaurantRating(5);
      espuelas1.setDatePosted(timestamp);
      reviewRepository.save(espuelas1);

      Review espuelas2 = new Review();
      espuelas2.setReview("The owners make every single customer feel welcomed and loved. They are great, and we are so lucky to have Las Espuelas in the neighborhood! Our children have grown from babies to big kids eating in the booths of Las Espuelas. We love it!");
      espuelas2.setRestaurant(restaurantRepository.findByName("Las Espuelas").get());
      espuelas2.setRestaurantRating(4);
      espuelas2.setDatePosted(timestamp);
      reviewRepository.save(espuelas2);

      Review phoMimosa1 = new Review();
      phoMimosa1.setReview("Best pho in the state, they use high quality meats and the broth is authentic not oily. The owners are very caring friendly people and the prices are not expensive either just right. My bf and I go there twice a week, definitely recommend.");
      phoMimosa1.setRestaurant(restaurantRepository.findByName("Phở Mimôsa").get());
      phoMimosa1.setRestaurantRating(5);
      phoMimosa1.setDatePosted(timestamp);
      reviewRepository.save(phoMimosa1);

      Review phoMimosa2 = new Review();
      phoMimosa2.setReview("Authentic Vietnamese food with some Thai options on the menu. High quality sliced beef, tendons and beef balls. Enjoyed the piping hot beef-based pho soup, after a chilly visit from the mountain pass.");
      phoMimosa2.setRestaurant(restaurantRepository.findByName("Phở Mimôsa").get());
      phoMimosa2.setRestaurantRating(4);
      phoMimosa2.setDatePosted(timestamp);
      reviewRepository.save(phoMimosa2);

      Review phoMimosa3 = new Review();
      phoMimosa3.setReview("My husband and I travel a lot this the best pho I've ever had. The meat was just right and there were a ton of noodles. We order egg rolls my son are 2 of them. The service was the best!! He was on top of everything. Please check this place out.");
      phoMimosa3.setRestaurant(restaurantRepository.findByName("Phở Mimôsa").get());
      phoMimosa3.setRestaurantRating(5);
      phoMimosa3.setDatePosted(timestamp);
      reviewRepository.save(phoMimosa3);

      Review phoMimosa4 = new Review();
      phoMimosa4.setReview("Authentic Pho! I'm from the Rainier Valley neighborhood where all the best Vietnamese restaurants are located in Seattle. This place has good pho. All ingredients were super fresh and tasty. The chefs are Vietnamese so you know they make other really great dishes I've yet to try.");
      phoMimosa4.setRestaurant(restaurantRepository.findByName("Phở Mimôsa").get());
      phoMimosa4.setRestaurantRating(4);
      phoMimosa4.setDatePosted(timestamp);
      reviewRepository.save(phoMimosa4);

      Review phoMimosa5 = new Review();
      phoMimosa5.setReview("By far my favorite restaurant around, I love when I can take people there for the first time! The staff is amazing and friendly! So far haven't had a chicken pho that compares to theirs. Always my favorite day(s) of the week.");
      phoMimosa5.setRestaurant(restaurantRepository.findByName("Phở Mimôsa").get());
      phoMimosa5.setRestaurantRating(5);
      phoMimosa5.setDatePosted(timestamp);
      reviewRepository.save(phoMimosa5);

      Review saigon1 = new Review();
      saigon1.setReview("This was the first place we went to eat after the stay at home order was lifted. I am so glad we chose this place to be our first sit down meal in months. I'm very picky about pho but I have no issues with saying this place was absolutely delicious. We both got the pho with steak and tripe, and it was excellent. Good noodle consistency, broth flavor and and temperature were on point. The meat and tripe were of good quality, tender and not too chewy. The Thai ice tea was creamy and had the perfect amount of sweetness. Overall, a fantastic find.");
      saigon1.setRestaurant(restaurantRepository.findByName("Saigon Pho And Grill").get());
      saigon1.setRestaurantRating(4);
      saigon1.setDatePosted(timestamp);
      reviewRepository.save(saigon1);

      Review saigon2 = new Review();
      saigon2.setReview("The pho is spot on. Great broth with a nice anise flavor. The pepper calamari was light and perfectly crisp. Lemongrass shrimp had a great flavor and was served like a typical bun style dish. Very good. I was surprised to see the amount of great grill options here that not all other pho places have. Great service as well.");
      saigon2.setRestaurant(restaurantRepository.findByName("Saigon Pho And Grill").get());
      saigon2.setRestaurantRating(5);
      saigon2.setDatePosted(timestamp);
      reviewRepository.save(saigon2);

      Review saigon3 = new Review();
      saigon3.setReview("The pho is very good. Is it the best I've ever had? No. Thus the four stars instead of five. But it's up there in the top dozen or so places, and remember where this is. Broth is flavorful and balanced. No one spice overpowers everything. The only issue I had with my bowl of brisket, tendon, and meatballs was the density of the meatballs. These are very dense. They're good, but their super dense nature makes them a little less appealing. The brisket was superb. Some of the best I have ever had, and the tendons were good and relatively plentiful.");
      saigon3.setRestaurant(restaurantRepository.findByName("Saigon Pho And Grill").get());
      saigon3.setRestaurantRating(4);
      saigon3.setDatePosted(timestamp);
      reviewRepository.save(saigon3);

      Review kona1 = new Review();
      kona1.setReview("This is as close to Hawaii as I've gotten so far. Another gem in my neighborhood that for some reason took me so long to actually try. I kicked myself for not eating here sooner!! Forget the quick and easy college Hawaiian bbq place, go for the real deal with Kona!!");
      kona1.setRestaurant(restaurantRepository.findByName("Kona Kitchen").get());
      kona1.setRestaurantRating(4);
      kona1.setDatePosted(timestamp);
      reviewRepository.save(kona1);

      Review kona2 = new Review();
      kona2.setReview("I think this might be Kona Kitchen's 1000th review! Anyways, I've gone here ever since I was a little kid, and came here for several events whether it was a birthday party, family reunion, or just to have some good food during breakfast, brunch, lunch, and even dinner. I've really been here for many occasions , and I have always enjoyed the food here and I've had basically the same order throughout all these years.");
      kona2.setRestaurant(restaurantRepository.findByName("Kona Kitchen").get());
      kona2.setRestaurantRating(5);
      kona2.setDatePosted(timestamp);
      reviewRepository.save(kona2);

      Review kona3 = new Review();
      kona3.setReview("Ordered the mochiko chicken and the kalua pig and cabbage for takeout. The kalua pig was VERY good - there is a depth of smoky flavor and the texture is also incredible. The mochiko chicken was okay - it's one of those things that I think might be better if it were dine-in. Something similar to be said about the mac salad - which tasted a bit overcooked, but my guess is that the steam from the rice inside the packaging softened everything. Prices are a bit high, but portions are also large. Would be happy to try again!");
      kona3.setRestaurant(restaurantRepository.findByName("Kona Kitchen").get());
      kona3.setRestaurantRating(4);
      kona3.setDatePosted(timestamp);
      reviewRepository.save(kona3);

      Review kona4 = new Review();
      kona4.setReview("Ordered takeout during COVID-19. I got 2 Spam Musubi ($2/ea) and 2 Portuguese Sausage Musubi ($3.60/ea). I also got Kalua Pork ($11.30). Musubis were all very tasty and the meat to rice ratio was perfect. Seaweed also didn't fall apart easily. Maybe could have used a little more sauce so it wouldn't be too dry, but the flavor of the meat was great. Kalua pork was also very tasty. Not dry at all and the cabbage had soaked in all the juices. It came with mac salad and rice, but the mac salad was almost too sweet. I expected it to be more savory. Overall the portion sizes were good and the food was pretty good. I wasn't amazed, but I was satisfied. I'd be willing to give this place another try to see if their other dishes are better.");
      kona4.setRestaurant(restaurantRepository.findByName("Kona Kitchen").get());
      kona4.setRestaurantRating(4);
      kona4.setDatePosted(timestamp);
      reviewRepository.save(kona4);
    }

  }
}

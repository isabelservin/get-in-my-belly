package com.launchacademy.reviews.seeders;

    import com.launchacademy.reviews.repositories.RestaurantRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.stereotype.Component;

    @Component
    public class C_LocationSeeder implements CommandLineRunner {
//      private LocationRepository locationRepository;
//      private RestaurantRepository restaurantRepository;
//
//      @Autowired
//      public C_LocationSeeder(LocationRepository locationRepository,
//          RestaurantRepository restaurantRepository) {
//        this.locationRepository = locationRepository;
//        this.restaurantRepository = restaurantRepository;
//      }

      @Override
      public void run(String...args) throws Exception {
//        List<Location> locations = (List<Location>) locationRepository.findAll();
//
//        if (locations.size() == 0) {
//          Location tamarindTree = new Location();
//          tamarindTree.setRestaurant(restaurantRepository.findByName("Tamarind Tree").get());
//          tamarindTree.setAddress("1036 S Jackson St, Seattle, WA 98104");
//          tamarindTree.setPhoneNumber("2068601404");
//          tamarindTree.setHealthDeptRating(3);
//          locationRepository.save(tamarindTree);
//
//          Location ohana = new Location();
//          ohana.setRestaurant(restaurantRepository.findByName("Ohana").get());
//          ohana.setAddress("2207 1st Ave, Seattle, WA 98121");
//          ohana.setPhoneNumber("2069569329");
//          ohana.setHealthDeptRating(3);
//          locationRepository.save(ohana);
//
//          Location elCamino = new Location();
//          elCamino.setRestaurant(restaurantRepository.findByName("El Camino").get());
//          elCamino.setAddress("607 N 35th St, Seattle, WA 98103");
//          elCamino.setPhoneNumber("2066327303");
//          elCamino.setHealthDeptRating(3);
//          locationRepository.save(elCamino);
//        }
      }
}

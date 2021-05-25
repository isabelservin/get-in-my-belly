package com.launchacademy.reviews.seeders;

import com.launchacademy.reviews.models.Category;
import com.launchacademy.reviews.repositories.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class A_CategorySeeder implements CommandLineRunner {
  private CategoryRepository categoryRepository;

  @Autowired
  public A_CategorySeeder(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void run(String...args) throws Exception {
    List<Category> categories = (List<Category>) categoryRepository.findAll();

    if (categories.size() == 0 ) {
      Category vietnamese = new Category();
      vietnamese.setType("Vietnamese");
      vietnamese.setDescription("The cuisine of Vietnam reflects the country's varied landscape and history using fresh aromatic herbs, pungent fish sauce, tart citrus and piquant pepper to create complex and unique dishes. Popular items include phở, gỏi cuốn (fresh spring rolls), bún chả (marinated grilled pork) and bánh mì.");
      categoryRepository.save(vietnamese);

      Category pacificIsland = new Category();
      pacificIsland.setType("Pacific Island");
      pacificIsland.setDescription("Pacific Island cuisine is as colorful and refreshing as the lands it originates from. Fresh fish, taro and other tubers and lots of tropical fruit are the primary ingredients in island fare. Popular items include Kalua Pork, Spam Musubi, Fish Poke, and Lau Lau");
      categoryRepository.save(pacificIsland);

      Category mexican = new Category();
      mexican.setType("Mexican");
      mexican.setDescription("The culinary traditions of Mexico vary by region and combine familiar ingredients such as corn, beans and chiles and less common ingredients like cactus, cacao, and amaranth to create a vast array of dishes. Popular items include Enchiladas Mole, Chile Rellenos, Chilaquiles and of course Tacos. ");
      categoryRepository.save(mexican);
    }

  }
}

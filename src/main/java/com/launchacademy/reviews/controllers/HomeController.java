package com.launchacademy.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping(value = {"/", "/category", "/category/restaurant", "/category/restaurant/:id", "/restaurants", "/restaurant/new", "review/new"})
  public String forward() {
    return "forward:/index.html";
  }
}

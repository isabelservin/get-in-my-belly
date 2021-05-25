package com.launchacademy.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping({"/", "/category", "/category/restaurant", "/category/restaurant/:id", "/restaurant", "/restaurant/new", "review/new"})
  public String forward() {
    return "forward:/";
  }
}

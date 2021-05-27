package com.launchacademy.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping(value = {"/categories", "/{categoryName}/restaurant/{id}", "/{categoryName}/restaurants", "/restaurant/new", "review/new", "/404"})
  public String forward() {
    return "forward:/";
  }
//  TESTTESTTEST
}

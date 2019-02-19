package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.services.FoodAndDrinkService;
import com.greenfoxacademy.programmerfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private FoxService foxService;
  private FoodAndDrinkService foodAndDrinkService;

  @Autowired
  public MainController(FoxService foxService, FoodAndDrinkService foodAndDrinkService) {
    this.foxService = foxService;
    this.foodAndDrinkService = foodAndDrinkService;
  }

  @GetMapping("/")
  public String showInformationPage(@RequestParam(required = false) String name, Model model) {
    if (name == null) {
      return "login";
    }

    model.addAttribute("fox", foxService.findOrCreateFoxByName(name));
    return "index";
  }

  @GetMapping("/login")
  public String showLoginForm() {
    return "login";
  }

  @PostMapping("/login")
  public String postLoginForm(@RequestParam String name) {
    return "redirect:/?name=" + name;
  }

  @GetMapping("/nutritionStore")
  public String showNutritionPage(@RequestParam String name, Model model){
    model.addAttribute("fox", foxService.findFoxByName(name));
    model.addAttribute("foods", foodAndDrinkService.findAllFoods());
    model.addAttribute("drinks", foodAndDrinkService.findAllDrinks());
    return "nutrition";
  }

  @PostMapping("/nutritionStore")
  public String showNutritionPage(@RequestParam String name, @RequestParam String food, @RequestParam String drink, Model model){
    Fox fox = foxService.findFoxByName(name);
    fox.setFood(food);
    fox.setDrink(drink);
    return "redirect:/?name=" + name;
  }

}

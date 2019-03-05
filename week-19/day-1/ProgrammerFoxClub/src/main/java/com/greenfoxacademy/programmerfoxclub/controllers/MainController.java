package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.services.FoodAndDrinkService;
import com.greenfoxacademy.programmerfoxclub.services.FoxService;
import com.greenfoxacademy.programmerfoxclub.services.TrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private FoxService foxService;
  private FoodAndDrinkService foodAndDrinkService;
  private TrickService trickService;

  @Autowired
  public MainController(FoxService foxService, FoodAndDrinkService foodAndDrinkService, TrickService trickService) {
    this.foxService = foxService;
    this.foodAndDrinkService = foodAndDrinkService;
    this.trickService = trickService;
  }

  @GetMapping("/foxclub")
  public String showWelcomePage() {
    return "welcome";
  }

  @GetMapping("/foxclub/login")
  public String showLoginForm(Model model) {
    return "login";
  }

  @GetMapping("/foxclub/register")
  public String showRegisterForm(Model model) {
    //model.addAttribute("name", null);
    return "register";
  }

  @PostMapping("/foxclub/login")
  public String postLoginForm(@ModelAttribute(value = "name") String name, Model model) {
    if (foxService.checkFoxByName(name)) {
      return "redirect:/foxclub/info?name=" + name;

    } else {
      model.addAttribute("warning", name + ", you are not yet registered. Register here!");
      model.addAttribute("name", name);
      return "register";
    }
  }

  @PostMapping("/foxclub/register")
  public String postRegisterForm(@ModelAttribute(value = "name") String name, Model model) {
    if (foxService.checkFoxByName(name)) {
      return "redirect:/foxclub/info?name=" + name;

    } else {
      model.addAttribute("name", name);
      model.addAttribute("freeimages", foxService.findFreeImages());
      return "foximages";
    }
  }

  @GetMapping("/foxclub/create")
  public String createFox(@RequestParam String name, @RequestParam String imageURL) {
    foxService.createFoxByName(name, imageURL);
    return "redirect:/foxclub/info?name=" + name;
  }

  @GetMapping("/foxclub/showPets")
  public String showPets(Model model) {
    model.addAttribute("foxes", foxService.findAllFoxes());
    return "showpets";
  }

  @GetMapping("/foxclub/info")
  public String showInformationPage(@RequestParam String name, Model model) {
    initFox(name, model);
    model.addAttribute("hungry", foxService.isFoxHungry(name));
    model.addAttribute("energylevel", foxService.currentEnergyLevel(name));
    model.addAttribute("lastactions", foxService.findLastActions(name));
    return "info";
  }

  @GetMapping("/foxclub/nutritionStore")
  public String showNutritionPage(@RequestParam String name, Model model) {
    initFox(name, model);
    model.addAttribute("foods", foodAndDrinkService.findAllFoods());
    model.addAttribute("drinks", foodAndDrinkService.findAllDrinks());
    return "nutrition";
  }

  @PostMapping("/foxclub/nutritionStore")
  public String showNutritionPage(@RequestParam String name, @ModelAttribute(value = "food") String food,
                                  @ModelAttribute(value = "drink") String drink) {
    foxService.setFoodAndDrinkForFox(name, food, drink);
    return "redirect:/foxclub/info?name=" + name;
  }

  @GetMapping("/foxclub/trickCenter")
  public String showTrickCenterPage(@RequestParam String name, @RequestParam(required = false) String warning, Model model) {
    initFox(name, model);
//    if (warning != null) {
    model.addAttribute("warning", warning);
//    }
    model.addAttribute("tricks", trickService.findTricksNotKnown(name));
    return "trickcenter";
  }

  @PostMapping("/foxclub/trickCenter")
  public String showTrickCenterPage(@RequestParam String name, @ModelAttribute(value = "trick") String trick) {
    if (foxService.addTrickForFox(name, trick)) {
      return "redirect:/foxclub/info?name=" + name;

    } else {
      String warning = name + " can not concentrate, he is hungry. Feed him first enabling him to learn: " + trick;
      return "redirect:/foxclub/trickCenter?name=" + name + "&warning=" + warning;
    }
  }

  @GetMapping("/foxclub/actionHistory")
  public String showActionHistoryPage(@RequestParam String name, Model model) {
    initFox(name, model);
    return "actionhistory";
  }

  private void initFox(String name, Model model) {
    Fox fox = foxService.findFoxByName(name);
    model.addAttribute("fox", fox);
  }

}

package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.services.FoodAndDrinkService;
import com.greenfoxacademy.programmerfoxclub.services.FoxService;
import com.greenfoxacademy.programmerfoxclub.services.ImageService;
import com.greenfoxacademy.programmerfoxclub.services.TrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {

  private FoxService foxService;
  private ImageService imageService;
  private FoodAndDrinkService foodAndDrinkService;
  private TrickService trickService;

  @Autowired
  public MainController(FoxService foxService, ImageService imageService, FoodAndDrinkService foodAndDrinkService, TrickService trickService) {
    this.foxService = foxService;
    this.imageService = imageService;
    this.foodAndDrinkService = foodAndDrinkService;
    this.trickService = trickService;
  }

  @GetMapping("/foxclub")
  public String showWelcomePage() {
    return "welcome";
  }

  //szeretnénk bejelentkezni egy már létező róka nevével:
  @GetMapping("/foxclub/login")
  public String showLoginForm(Model model) {
    return "login";
  }

  //szeretnénk létrehozni egy új rókát (névvel és képpel):
  @GetMapping("/foxclub/register")
  public String showRegisterForm(@ModelAttribute Fox fox, Model model) {
    model.addAttribute("fox", fox); //üresen jelenik meg a kitöltési mező (de ha sikertelen loginolás után kerülök ide, akkor nem üres, hanem a login oldalon megadott név jelenik meg benne)
    return "register";
  }

  //a loginolás után meg kell vizsgálni, hogy létezik-e ilyen nevű róka, ha igen, megjelenítem az infooldalát, ha nem, akkor létre kell hozni őt a regisztrációs oldalon
  @PostMapping("/foxclub/login")
  public String postLoginForm(@ModelAttribute(value = "name") String name, Model model) {
    if (foxService.checkFoxByName(name)) {
      return "redirect:/foxclub/info?name=" + name; //ha már van ilyen nevű róka, akor megjelenítem az info oldalt erről a rókáról

    } else { //ha még nincs ilyen nevű róka, akkor előbb regisztrálni kell ezzel a névvel:
      model.addAttribute("warning", name + ", you are not yet registered. Register here!");
      model.addAttribute("fox", new Fox(name)); //így töltöm fel a regisztrációs form mezőjét azzal a névvel, amit a login oldalon megadtam (hogy ne üresen jelenjen meg)
      return "register";
    }
  }

  //ide érkezik a vezérlés a sima regisztrálás után, illetve azután is, hogy nem sikerült beloginolni, mert előbb regisztrálni kell:
  @PostMapping("/foxclub/register")
  public String postRegisterForm(@ModelAttribute(value = "name") String name, Model model) {
    if (foxService.checkFoxByName(name)) { //ha a sima regisztráláskor kiderül, hogy már van ilyen nevű róka, akkor nem kell regisztrálni, hanem megjelenítem az info oldalt eről a rókáról
      return "redirect:/foxclub/info?name=" + name;

    } else { //itt kerül sor a tényleges regisztrálásra, vagyis választani kell előbb egy róka képet, majd létrehozni a rókát a megadott névvel és kiválasztott képpel:
      model.addAttribute("name", name);
      ArrayList<String> occupiedImages = foxService.findFoxImages();
      model.addAttribute("freeimages", imageService.findFreeImages(occupiedImages));
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
    model.addAttribute("fox", foxService.findFoxByName(name));
    model.addAttribute("lastactions", foxService.findLastActions(name));
    return "info";
  }

//  @GetMapping("/")
//  public String showInformationPage(@RequestParam(required = false) String name, Model model) {
//    if (name == null) {
//      return "login";
//    }
//    model.addAttribute("fox", foxService.findOrCreateFoxByName(name));
//    model.addAttribute("lastactions", foxService.findLastActions(name));
//    return "index";
//  }

//  @GetMapping("/login")
//  public String showLoginForm() {
//    return "login";
//  }
//
//  @PostMapping("/login")
//  public String postLoginForm(@RequestParam String name) {
//    return "redirect:/?name=" + name;
//  }

  @GetMapping("/foxclub/nutritionStore")
  public String showNutritionPage(@RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.findFoxByName(name));
    model.addAttribute("foods", foodAndDrinkService.findAllFoods());
    model.addAttribute("drinks", foodAndDrinkService.findAllDrinks());
    return "nutrition";
  }

  @PostMapping("/foxclub/nutritionStore")
  public String showNutritionPage(@RequestParam String name, @ModelAttribute(value = "food") String food, @ModelAttribute(value = "drink") String drink, Model model) {
    foxService.setFoodAndDrinkForFox(name, food, drink);
    return "redirect:/foxclub/info?name=" + name;
  }

  @GetMapping("/foxclub/trickCenter")
  public String showTrickCenterPage(@RequestParam String name, Model model) {
    Fox fox = foxService.findFoxByName(name);
    model.addAttribute("fox", fox);
    model.addAttribute("tricks", trickService.findTricksNotKnown(fox));
    return "trickcenter";
  }

  @PostMapping("/foxclub/trickCenter")
  public String showTrickCenterPage(@RequestParam String name, @ModelAttribute(value = "trick") String trick, Model model) {
    foxService.addTrickForFox(name, trick);
    return "redirect:/foxclub/info?name=" + name;
  }

  @GetMapping("/foxclub/actionHistory")
  public String showActionHistoryPage(@RequestParam String name, Model model) {
    Fox fox = foxService.findFoxByName(name);
    model.addAttribute("fox", fox);
    return "actionhistory";
  }

}

package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloToTheWorldWebController {

  private String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
          "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
          "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
          "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

  @RequestMapping("/web/greetingToTheWorld")
  public String greetingToTheWorld(Model model) {
    String greetings = createGreetings();
    model.addAttribute("greetings", greetings);
    return "greetingInManyLanguages";
  }

  @RequestMapping("/web/greetingFromTheWorld")
  public String greetingFromTheWorld(Model model, @RequestParam String name) {
    model.addAttribute("name", name);
    model.addAttribute("greeting", findRamdomGreeting());
    return "greetingInManyLanguages";
  }

  private String createGreetings() {
    String result = "";
    for (String hello : hellos) {
      result += hello + ", ";
    }
    return result;
  }

  private String findRamdomGreeting() {
    int size = hellos.length;
    int randomIndex = (int) (Math.random() * size);
    return hellos[randomIndex];
  }

}

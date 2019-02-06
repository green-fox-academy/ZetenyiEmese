package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWebController {

  private AtomicLong apiCalls = new AtomicLong(0);

  @RequestMapping("/web/greeting")
  public String greeting(Model model) {
    model.addAttribute("name", " World");
    return "greeting";
  }

  @RequestMapping("/web/greeting2")
  public String greeting2(Model model) {
    model.addAttribute("name", " Emese");
    model.addAttribute("apiCalls", apiCalls.incrementAndGet());
    return "greeting";
  }

  @RequestMapping("/web/greeting3")
  public String greeting3(Model model, @RequestParam String name) {
    model.addAttribute("name", name);
    model.addAttribute("apiCalls", apiCalls.incrementAndGet());
    return "greeting";
  }

}

package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

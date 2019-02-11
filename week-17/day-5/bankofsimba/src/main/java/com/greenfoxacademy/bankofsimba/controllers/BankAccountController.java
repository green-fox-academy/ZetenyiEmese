package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankAccountController {

  @GetMapping("/show")
  public String show(Model model) {
    model.addAttribute("bankAccount", new BankAccount("Simba", 2000, "lion"));
    return "bankAccount";
  }

}

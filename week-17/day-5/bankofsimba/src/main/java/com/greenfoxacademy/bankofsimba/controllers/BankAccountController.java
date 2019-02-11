package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BankAccountController {

  private List<BankAccount> bankAccounts = new ArrayList<>();

  public BankAccountController() {
    bankAccounts.add(new BankAccount("Simba", 1500, "lion"));
    bankAccounts.add(new BankAccount("Nala", 500, "lion"));
    bankAccounts.add(new BankAccount("Zazu", 700, "hornbill"));
    bankAccounts.add(new BankAccount("Zordon", 1000, "lion"));
    bankAccounts.add(new BankAccount("Ed", 100, "hyena"));
    bankAccounts.add(new BankAccount("Timon", 150, "meerkat"));
    bankAccounts.add(new BankAccount("Pumbaa", 300, "warthog"));
  }

  @GetMapping("/showSimba")
  public String showSimbaAccount(Model model) {
    model.addAttribute("bankAccount", new BankAccount("Simba", 2000, "lion"));
    return "bankAccountOfSimba";
  }

  @GetMapping("/showAll")
  public String showAllAccounts(Model model) {
    model.addAttribute("bankAccounts", bankAccounts);
    return "bankAccounts";
  }

}

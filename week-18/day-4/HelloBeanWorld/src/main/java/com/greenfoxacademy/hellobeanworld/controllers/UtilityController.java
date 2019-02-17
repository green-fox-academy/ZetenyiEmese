package com.greenfoxacademy.hellobeanworld.controllers;

import com.greenfoxacademy.hellobeanworld.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilityController {

  @Autowired
  private UtilityService utilityService;

  //localhost:8080/useful
  @GetMapping("/useful")
  public String showUtilities() {
    return"main";
  }

  //localhost:8080/useful/color
  @GetMapping("/useful/color")
  public String showColor(Model model) {
    String color = utilityService.randomColor();
    model.addAttribute("color", color);
    return"color";
  }

  //localhost:8080/useful/email?emailAddress=is@this.valid
  @GetMapping("/useful/email")
  public String showEmail(@RequestParam String emailAddress, Model model) {
    boolean isValid = utilityService.validateEmail(emailAddress);
    model.addAttribute("isValid", isValid);
    model.addAttribute("emailAddress", emailAddress);
    return "emailvalidation";
  }

//  //localhost:8080/useful/emailvalidation
//  @GetMapping("/useful/emailvalidation")
//  public String showEmailForm() {
//    return "emailvalidationForm";
//  }

  //localhost:8080/useful/emailvalidation
  @GetMapping("/useful/emailvalidation")
  public String showEmailForm(Model model) {
    Email email = new Email("is@this.valid");
    boolean isValid = utilityService.validateEmail(email.getAddress());
    model.addAttribute("isValid", isValid);
    model.addAttribute("email", email);
    return "emailvalidationForm2";
  }

  @PostMapping("/useful/emailvalidation")
  public String showEmailSubmit(@ModelAttribute Email email, Model model) {
    boolean isValid = utilityService.validateEmail(email.getAddress());
    model.addAttribute("isValid", isValid);
    model.addAttribute("email", email);
    return "emailvalidationForm2";
  }

  //localhost:8080/useful/encode?text=example&number=1
  @GetMapping("/useful/encode")
  public String encode(@RequestParam String text, int number, Model model) {
    String encodedText = utilityService.caesar(text, number);
    model.addAttribute("codedText", encodedText);
    return "caesarcoding";
  }

  //localhost:8080/useful/decode?text=fybnqmf&number=-1
  @GetMapping("/useful/decode")
  public String decode(@RequestParam String text, int number, Model model) {
    String decodedText = utilityService.caesar(text, number);
    model.addAttribute("codedText", decodedText);
    return "caesarcoding";
  }

}

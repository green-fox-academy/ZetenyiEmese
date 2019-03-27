package com.greenfoxacademy.redditapp.controllers;

import com.greenfoxacademy.redditapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  private UserService userService;

  @Autowired
  public LoginController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/register")
  public String showRegisterForm(Model model) {
    //model.addAttribute("username", null);
    return "register";
  }

  @PostMapping("/register")
  public String postRegisterForm(@ModelAttribute(value = "username") String username,
                                 @ModelAttribute(value = "email") String email,
                                 @ModelAttribute(value = "password") String password, Model model) {
    if (userService.checkUserByName(username)) {
      model.addAttribute("warning", "You can not register with this username. It is already used. Enter another username!");
      model.addAttribute("username", username);
      return "register";

    } else {
      userService.addUser(username, password, email);
      long userId = userService.findIdForUserWithName(username);
      return "redirect:/" + userId + "/true";
    }
  }

  @GetMapping("/login")
  public String showLoginForm(Model model) {
    return "login";
  }

  @PostMapping("/login")
  public String postLoginForm(@ModelAttribute(value = "username") String username,
                              @ModelAttribute(value = "password") String password, Model model) {
    if (!userService.checkUserByName(username)) {
      model.addAttribute("warning", username + ", you are not yet registered. Register here!");
      model.addAttribute("username", username);
      return "register";

    } else if (!userService.checkUserByNameAndPassword(username, password)) {
      model.addAttribute("warning", "Wrong password!");
      model.addAttribute("username", username);
      return "login";

    } else {
      long userId = userService.findIdForUserWithName(username);
      return "redirect:/" + userId + "/true";
    }
  }

}

package com.greenfoxacademy.bankofsimba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TextController {

  @GetMapping("/showtext")
  @ResponseBody
  public String showText() {
    return "\"This is an <em>HTML</em> text. <b>Enjoy yourself!</b>\"";
    //"This is an HTML text. Enjoy yourself!"
  }

  @GetMapping("/showtext2")
  public String showText2(Model model) {
    model.addAttribute("text", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "text";
    //th:text This is an <em>HTML</em> text. <b>Enjoy yourself!</b>
    //th:utext This is an HTML text. Enjoy yourself!
  }

}

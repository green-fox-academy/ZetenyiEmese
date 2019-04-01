package com.greenfoxacademy.frontendjson.controllers;

import com.greenfoxacademy.frontendjson.models.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {

//  @GetMapping("/doubling")
//  public Integer doubling(@RequestParam int input){
//    return 2*input; //30
//  }

  @GetMapping("/doubling")
  public Object doubleInput(@RequestParam(required = false) Integer input) {
    if (input != null) {
      return new Doubling(input);
    } else {
      return new MyError("Please provide an input!");
    }
  }

  @GetMapping("/greeter")
  public Object greetSomebody(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String title) {
    if (name != null && title != null) {
      return new Greeting(name, title);
    } else if (name == null && title == null) {
      return new MyError("Please provide a name and a title!");
    } else if (name == null) {
      return new MyError("Please provide a name!");
    } else {
      return new MyError("Please provide a title!");
    }
  }

  @GetMapping("appenda/{appendable}")
  public Object appendA(@PathVariable String appendable) {
    if (appendable != null) {
      return new Appended(appendable);
    } else {
      return "redirect:/error";
    }
  }

  @PostMapping("dountil/{action}")
  public Object doAction(@PathVariable String action, @RequestBody Until jsonUntil) {
    if (jsonUntil != null) {
      if (action.equals("sum")) {
        return new Sum(jsonUntil.getUntil());
      } else if (action.equals("factor")) {
        return new Factorial(jsonUntil.getUntil());
      } else {
        return "redirect:/error";
      }
    } else {
      return new MyError("Please provide a number!");
    }
  }

  @GetMapping("/error")
  public String error() {
    return "404";
  }

}

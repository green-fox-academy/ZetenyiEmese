package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.Greeting;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {

  private AtomicLong apiCalls = new AtomicLong(0);

  @RequestMapping(value = "/greeting")
  public Greeting greeting() {
    return new Greeting(1, "Hello, World");
  }

  @RequestMapping(value = "/greeting2")
  public Greeting greeting2(@RequestParam String name) {
    return new Greeting(1, "Hello " + name);
  }

  @RequestMapping(value = "/greeting3/{name}")
  public Greeting greeting3(@PathVariable String name) {
    return new Greeting(1, "Hello " + name);
  }

  @RequestMapping(value = "/greeting4")
  public Greeting greeting4(@RequestParam String name) {
    return new Greeting(apiCalls.incrementAndGet(), "Hello " + name);
  }

}

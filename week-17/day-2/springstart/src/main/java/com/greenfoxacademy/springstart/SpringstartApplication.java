package com.greenfoxacademy.springstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class SpringstartApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringstartApplication.class, args);
  }

  //URL: http://localhost:8080/hello
  @RequestMapping(value = "/hello")
  @ResponseBody
  public String hello() {
    return "Hello World!";
  }

  //URL: http://localhost:8080/hello/Emese
  @RequestMapping(value = "hello/{name}")
  @ResponseBody
  public String hello(@PathVariable String name) {
    return "Hello " + name + "!";
  }

  //URL: http://localhost:8080/otherhello?name=Eme
  @RequestMapping(value = "/otherhello")
  @ResponseBody
  public String hello2(@RequestParam String name) {
    return "Hello " + name + "!";
  }

  //URL: http://localhost:8080/helloToBoth?name1=Eme&name2=Miki
  @RequestMapping(value = "/helloToBoth")
  @ResponseBody
  public String hello3(@RequestParam String name1, String name2) {
    return "Hello " + name1 + " & " + name2 + "!";
  }

  //URL: http://localhost:8080/hello4/Mikulas?name1=Eme&name2=Miki
  @RequestMapping(value = "hello4/{name}")
  @ResponseBody
  public String hello4(@PathVariable String name, @RequestParam String name1, String name2) {
    return "Hello " + name + " & " + name1 + " & " + name2 + "!";
  }

}

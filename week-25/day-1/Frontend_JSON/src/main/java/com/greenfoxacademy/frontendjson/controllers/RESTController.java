package com.greenfoxacademy.frontendjson.controllers;

import com.greenfoxacademy.frontendjson.models.*;
import com.greenfoxacademy.frontendjson.services.ArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {

  private ArrayService arrayService;

  @Autowired
  public RESTController(ArrayService arrayService) {
    this.arrayService = arrayService;
  }

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

  @GetMapping("/appenda/{appendable}")
  public Object appendA(@PathVariable String appendable) {
    if (appendable != null) {
      return new AppendA(appendable);
    } else {
      return "redirect:/error";
    }
  }

  @PostMapping("/dountil/{action}")
  public Object doAction(@PathVariable(name = "action") String act,
                         @RequestBody(required = false) Until until) {
    if (until != null) {
      if (act.equals("sum")) {
        return new Sum(until.getUntil());
      } else if (act.equals("factor")) {
        return new Factorial(until.getUntil());
      } else{
        return new Error("Please provide a valid operation to perform!");
      }

    } else {
      return new MyError("Please provide a number!"); //ha nem küldünk JSON-t
    }
  }

  @PostMapping("/arrays")
  public ResponseEntity<Object> doArrayHandling(@RequestBody(required = false) ArrayHandler arrayHandler) {
    if (arrayHandler != null) { //ha üres, vagy hiányos JSON-t küldünk, akkor is felépül az arrayHandler objektum (nem lesz null!)
      String action = arrayHandler.getWhat();
      int[] numbers = arrayHandler.getNumbers();

      if (action != null && numbers != null) {
        if (action.equals("sum") || action.equals("multiply") || action.equals("double")) {
          return ResponseEntity.status(HttpStatus.OK).body(arrayService.handleArray(action, numbers));
        } else {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Please provide a valid operation to perform!"));
        }

      } else if (action == null && numbers == null){ //ha üres JSON-t küldünk
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Please provide what to do!"));

      } else if (action == null){ //ha hiányos JSON-t küldünk
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Please provide what to do with the numbers!"));

      } else {  //ha hiányos JSON-t küldünk
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Please provide the numbers!"));
      }
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Please provide what to do, what to do!")); //ha nem küldünk JSON-t
  }

  @GetMapping("/error")
  public String error() {
    return "404";
  }

}

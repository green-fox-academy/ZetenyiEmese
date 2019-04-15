package com.greenfoxacademy.frontendjson.controllers;

import com.greenfoxacademy.frontendjson.models.*;
import com.greenfoxacademy.frontendjson.services.ArrayService;
import com.greenfoxacademy.frontendjson.services.LogService;
import com.greenfoxacademy.frontendjson.services.SithService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RESTController {

  private ArrayService arrayService;
  private LogService logService;
  private SithService sithService;

  @Autowired
  public RESTController(ArrayService arrayService, LogService logService, SithService sithService) {
    this.arrayService = arrayService;
    this.logService = logService;
    this.sithService = sithService;
  }

//  @GetMapping("/doubling")
//  public Integer doubling(@RequestParam int input){
//    return 2*input; //30
//  }

  @GetMapping("/doubling")
  public Object doubleInput(@RequestParam(required = false) Integer input) {
    logService.addLog(new Log("/doubling", "input=" + input));

    if (input != null) {
      return new Doubling(input);
    } else {
      return new MyError("Please provide an input!");
    }
  }

  @GetMapping("/greeter")
  public Object greetSomebody(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String title) {
    logService.addLog(new Log("/greeter", "name=" + name + "&" + "title=" + title));

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
  public Object appendA(@PathVariable(required = false) String appendable) {
    logService.addLog(new Log("/appenda/" + appendable, appendable));

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
      logService.addLog(new Log("/dountil/" + act, until.toString()));

      if (until.getUntil() > 0) {
        if (act.equals("sum")) {
          return new Sum(until.getUntil());
        } else if (act.equals("factor")) {
          return new Factorial(until.getUntil());
        } else {
          return new MyError("Please provide a valid operation to perform!");
        }
      } else { //ha üres JSON-t küldünk:
        return new MyError("Please provide a number!");
      }

    } else { //ha nem küldünk JSON-t:
      logService.addLog(new Log("/dountil/" + act, "no data"));
      return new MyError("Please provide a number!");
    }
  }

  @PostMapping("/arrays")
  public ResponseEntity<Object> doArrayHandling(@RequestBody(required = false) ArrayHandler arrayHandler) {

    if (arrayHandler != null) { //ha üres, vagy hiányos JSON-t küldünk, akkor is felépül az arrayHandler objektum (nem lesz null!)
      logService.addLog(new Log("/arrays", arrayHandler.toString()));

      String action = arrayHandler.getWhat();
      int[] numbers = arrayHandler.getNumbers();

      if (action != null && numbers != null) {
        if (action.equals("sum") || action.equals("multiply") || action.equals("double")) {
          return ResponseEntity.status(HttpStatus.OK).body(arrayService.handleArray(action, numbers));
        } else {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Please provide a valid operation to perform!"));
        }

      } else if (action == null && numbers == null) { //ha üres JSON-t küldünk:
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Please provide what to do!"));

      } else if (action == null) { //ha hiányos JSON-t küldünk:
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Please provide what to do with the numbers!"));

      } else {  //ha hiányos JSON-t küldünk:
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Please provide the numbers!"));
      }

    } else { //ha nem küldünk JSON-t:
      logService.addLog(new Log("/arrays", "no data"));
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Please provide what to do, what to do!"));
    }
  }

  @PostMapping("/sith")
  public ResponseEntity<Object> transformText(@RequestBody(required = false) Text text) {
    if (text != null && text.getText() != null) {
      return ResponseEntity.status(HttpStatus.OK).body(sithService.transformText(text));
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError("Feed me some text you have to, padawan young you are. Hmmm."));
  }

  @GetMapping("/log")
  public LogList getAllLogs() {
    ArrayList<Log> logs = logService.findAllLogs();
    return new LogList(logs, logs.size());
  }

  @GetMapping("/error")
  public String error() {
    return "My 404";
  }

}

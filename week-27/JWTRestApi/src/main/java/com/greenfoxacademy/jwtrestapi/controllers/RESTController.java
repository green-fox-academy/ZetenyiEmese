package com.greenfoxacademy.jwtrestapi.controllers;

import com.greenfoxacademy.jwtrestapi.models.JsonUser;
import com.greenfoxacademy.jwtrestapi.security.jwt.JWTUtility;
import com.greenfoxacademy.jwtrestapi.services.TodoService;
import com.greenfoxacademy.jwtrestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

  private UserService userService;
  private TodoService todoService;

  @Autowired
  public RESTController(UserService userService, TodoService todoService) {
    this.userService = userService;
    this.todoService = todoService;
  }

  @PostMapping("/api/register")
  public ResponseEntity<String> register(@RequestBody JsonUser jsonUser){
    String username = jsonUser.getUsername();
    String password = jsonUser.getPassword();

    if (userService.checkUserByName(username)) {
      return ResponseEntity.status(401).body("The user already exists!");
    }
    userService.saveUser(username, password);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + JWTUtility.generateToken(username));
    return new ResponseEntity<>(headers, HttpStatus.OK);
  }

  @PostMapping("/api/login")
  public ResponseEntity<String> login(@RequestBody JsonUser jsonUser){
    String username = jsonUser.getUsername();
    String password = jsonUser.getPassword();

    if (!userService.checkUserByName(username)) {
      return ResponseEntity.status(401).body("The user doesn't exist!");
    }
    if (!userService.checkUserByNameAndPassword(username, password)) {
      return ResponseEntity.status(401).body("The password is incorrect!");
    }

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + JWTUtility.generateToken(username));
    return new ResponseEntity<>(headers, HttpStatus.OK);
  }

}

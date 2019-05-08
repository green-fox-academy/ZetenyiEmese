package com.greenfoxacademy.jwtrestapi.controllers;

import com.greenfoxacademy.jwtrestapi.models.JsonTodo;
import com.greenfoxacademy.jwtrestapi.models.JsonUser;
import com.greenfoxacademy.jwtrestapi.models.Todo;
import com.greenfoxacademy.jwtrestapi.security.jwt.JWTUtility;
import com.greenfoxacademy.jwtrestapi.services.TodoService;
import com.greenfoxacademy.jwtrestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    if ((username == null || username.isEmpty()) && (password == null || password.isEmpty())) {
      return ResponseEntity.status(401).body("Enter the username and the password!");
    }
    if (username == null || username.isEmpty()) {
      return ResponseEntity.status(401).body("Enter the username!");
    }
    if (password == null || password.isEmpty()) {
      return ResponseEntity.status(401).body("Enter the password!");
    }
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

    if ((username == null || username.isEmpty()) && (password == null || password.isEmpty())) {
      return ResponseEntity.status(401).body("Enter the username and the password!");
    }
    if (username == null || username.isEmpty()) {
      return ResponseEntity.status(401).body("Enter the username!");
    }
    if (password == null || password.isEmpty()) {
      return ResponseEntity.status(401).body("Enter the password!");
    }
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

  @PostMapping("api/addTodo")
  public ResponseEntity<String> addTodo(@RequestHeader("Authorization") String token, @RequestBody JsonTodo jsonTodo){
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    todoService.saveTodo(username, jsonTodo);
//    return ResponseEntity.status(HttpStatus.OK).body("The todo was added!");
    return ResponseEntity.status(HttpStatus.OK).header("Authorization", token).body("The todo was added!");
  }

  @GetMapping("api/listTodos")
  public ResponseEntity<Object> listTodos(@RequestHeader("Authorization") String token){
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    ArrayList<Todo> todos = todoService.findTodosByUser(username);
//    return ResponseEntity.status(HttpStatus.OK).body(todos);
    return ResponseEntity.status(HttpStatus.OK).header("Authorization", token).body(todos);
  }

}

package com.greenfoxacademy.listingtodos.controllers;

import com.greenfoxacademy.listingtodos.models.Todo;
import com.greenfoxacademy.listingtodos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping("/")
  @ResponseBody
  public String list() {
    return "This is my first Todo";
  }

  @GetMapping("/list")
  public String list(Model model) {
    List<Todo> todos = new ArrayList<>();
    todoRepository.findAll().forEach(todos::add);
    model.addAttribute("todos", todos);
    return "todolist";
  }

}

package com.greenfoxacademy.listingtodosmysql.controllers;

import com.greenfoxacademy.listingtodosmysql.models.Todo;
import com.greenfoxacademy.listingtodosmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping("/")
  public String list(@RequestParam(required = false) Boolean isActive, Model model) {
    List<Todo> todos;

    if (isActive != null) {
      todos = todoRepository.findByDone(!isActive);
    } else {
      //todoRepository.findAll().forEach(todos::add);
      todos = todoRepository.findAll();
    }

    model.addAttribute("todos", todos);
    return "todolist";
  }

  @GetMapping("/add")
  public String addTodo() {
    return "addtodo";
  }

  @PostMapping("/add")
  public String addTodo(@ModelAttribute(value = "desc") String description) {
    todoRepository.save(new Todo(description));
    return "redirect:/todo/";
  }

//  @GetMapping("/{id}/delete")
//  public String deleteTodo(@PathVariable long id) {
//    todoRepository.deleteById(id);
//    return "redirect:/todo/";
//  }

  @PostMapping("/{id}/delete")
  public String deleteTodo2(@PathVariable long id) {
    todoRepository.deleteById(id);
    return "redirect:/todo/";
  }

//  @PostMapping("/delete")
//  public String deleteTodo3(@ModelAttribute(value = "todoId") long id) {
//    todoRepository.deleteById(id);
//    return "redirect:/todo/";
//  }

  @GetMapping("/{id}/edit")
  public String editTodo(@PathVariable long id, Model model) {
    Optional<Todo> todoOptionalInDatabase = todoRepository.findById(id);

    if (todoOptionalInDatabase.isPresent()) {
      model.addAttribute("todo", todoOptionalInDatabase.get());
    }
    return "edittodo";
  }

  @PostMapping("/edit")
  public String editTodo(@ModelAttribute Todo todoComingFromTheForm) {
    Optional<Todo> todoOptionalInDatabase = todoRepository.findById(todoComingFromTheForm.getId());

    if (todoOptionalInDatabase.isPresent()) {
      Todo todoInDataBase = todoOptionalInDatabase.get();
      todoInDataBase.setDescription(todoComingFromTheForm.getDescription());
      todoInDataBase.setUrgent(todoComingFromTheForm.isUrgent());
      todoInDataBase.setDone(todoComingFromTheForm.isDone());
      todoRepository.save(todoInDataBase);
      //todoRepository.save(todoComingFromTheForm); //felülírja a régi todot az új, formos todoval, hiszen ugyanaz az id-jük
    }
    return "redirect:/todo/";
  }

//  @PostMapping("/{id}/edit")
//  public String editTodo(@ModelAttribute Todo todoComingFromTheForm) {
//    todoRepository.save(todoComingFromTheForm);
//    return "redirect:/todo/";
//  }

  @GetMapping("/{id}/details")
  public String detailsTodo(@PathVariable long id, Model model) {
    Optional<Todo> todoOptionalInDatabase = todoRepository.findById(id);

    if (todoOptionalInDatabase.isPresent()) {
      model.addAttribute("todo", todoOptionalInDatabase.get());
    }
    return "tododetails";
  }

}

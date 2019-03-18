package com.greenfoxacademy.listingtodoswithassigneesmsql.controllers;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Todo;
import com.greenfoxacademy.listingtodoswithassigneesmsql.services.TodoService;
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

  private TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/")
  public String list(@RequestParam(required = false) Boolean isActive,
                     @RequestParam(required = false) String descriptionPart, Model model) {
    List<Todo> filteredTodos = new ArrayList<>();

    if (isActive != null) {
      filteredTodos = todoService.findByDone(!isActive);
    } else if (descriptionPart != null) {
      filteredTodos = todoService.findTodosByDescriptionContaining(descriptionPart);
    } else {
      //todoRepository.findAll().forEach(filteredTodos::add);
      filteredTodos = todoService.findAllTodos();
    }

    model.addAttribute("descriptionPart", descriptionPart);
    model.addAttribute("todos", filteredTodos);
    return "todolist";
  }

  @GetMapping("/add")
  public String addTodo() {
    return "addtodo";
  }

  @PostMapping("/add")
  public String addTodo(@ModelAttribute(value = "desc") String description) {
    todoService.addTodo(new Todo(description));
    return "redirect:/todo/";
  }

  @PostMapping("/{todoId}/delete")
  public String deleteTodo(@PathVariable long todoId) {
    todoService.deleteTodo(todoId);
    return "redirect:/todo/";
  }

  @GetMapping("/{todoId}/edit")
  public String editTodo(@PathVariable long todoId, Model model) {
    Optional<Todo> todoOptionalInDatabase = todoService.findTodo(todoId);

    if (todoOptionalInDatabase.isPresent()) {
      model.addAttribute("todo", todoOptionalInDatabase.get());
    }
    return "edittodo";
  }

  @PostMapping("/edit")
  public String editTodo(@ModelAttribute Todo todoComingFromTheForm) {
    Optional<Todo> todoOptionalInDatabase = todoService.findTodo(todoComingFromTheForm.getTodoId());

    if (todoOptionalInDatabase.isPresent()) {
      Todo todoInDataBase = todoOptionalInDatabase.get();
      todoInDataBase.setDescription(todoComingFromTheForm.getDescription());
      todoInDataBase.setUrgent(todoComingFromTheForm.isUrgent());
      todoInDataBase.setDone(todoComingFromTheForm.isDone());
      todoService.addTodo(todoInDataBase); //felülírja a régi todo-t  az újjal, mert ugyanaz az id-jük
    }
    return "redirect:/todo/";
  }

  @GetMapping("/{todoId}/details")
  public String detailsTodo(@PathVariable long todoId, Model model) {
    Optional<Todo> todoOptionalInDatabase = todoService.findTodo(todoId);

    if (todoOptionalInDatabase.isPresent()) {
      model.addAttribute("todo", todoOptionalInDatabase.get());
    }
    return "tododetails";
  }

}

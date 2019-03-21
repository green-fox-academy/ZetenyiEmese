package com.greenfoxacademy.listingtodoswithassigneesmsql.controllers;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Assignee;
import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Todo;
import com.greenfoxacademy.listingtodoswithassigneesmsql.services.AssigneeService;
import com.greenfoxacademy.listingtodoswithassigneesmsql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private TodoService todoService;
  private AssigneeService assigneeService;

  @Autowired
  public TodoController(TodoService todoService, AssigneeService assigneeService) {
    this.todoService = todoService;
    this.assigneeService = assigneeService;
  }

  @GetMapping("/")
//  public String showTodos(@RequestParam(required = false) Boolean isActive,
//                          @ModelAttribute(value = "descriptionPart") String descriptionPart, Model model) {
    public String showTodos(@RequestParam(required = false) Boolean isActive,
                            @RequestParam(required = false) String descriptionPart, Model model) {
    List<Todo> filteredTodos;

    if (isActive != null) {
      filteredTodos = todoService.findTodoByDone(!isActive);
    } else if (descriptionPart != null && !descriptionPart.isEmpty()) {
      filteredTodos = todoService.findTodosByDescriptionContaining(descriptionPart);
    } else {
      //todoRepository.findAll().forEach(filteredTodos::add);
      filteredTodos = todoService.findAllTodos();
    }

    model.addAttribute("descriptionPart", descriptionPart);
    model.addAttribute("todos", filteredTodos);
    return "todo_list";
  }

//  @GetMapping("/")
//  public String showTodos(@RequestParam(required = false) Boolean isActive,
//                          @ModelAttribute Todo todo, Model model) {
//    List<Todo> filteredTodos = new ArrayList<>();
//
//    if (isActive != null) {
//      filteredTodos = todoService.findByDone(!isActive);
//    } else if (todo.getDescription() != null) {
//      filteredTodos = todoService.findTodosByDescriptionContaining(todo.getDescription());
//    } else {
//      //todoRepository.findAll().forEach(filteredTodos::add);
//      filteredTodos = todoService.findAllTodos();
//    }
//
//    model.addAttribute("todos", filteredTodos);
//    return "todolist";
//  }

  @GetMapping("/addTodo")
  public String addTodo() {
    return "add_todo";
  }

  @PostMapping("/addTodo")
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
    Optional<Todo> todoOptionalInDatabase = todoService.findTodoById(todoId);

    if (todoOptionalInDatabase.isPresent()) {
      model.addAttribute("todo", todoOptionalInDatabase.get());
      model.addAttribute("assignees", assigneeService.findAllAssignees());
    }
    return "edit_todo";
  }

  @PostMapping("/edit")
  public String editTodo(@ModelAttribute Todo todoComingFromTheForm) {
    Optional<Todo> todoOptionalInDatabase = todoService.findTodoById(todoComingFromTheForm.getTodoId());

    if (todoOptionalInDatabase.isPresent()) {
      Todo todoInDataBase = todoOptionalInDatabase.get();
      todoInDataBase.setDescription(todoComingFromTheForm.getDescription());
      todoInDataBase.setUrgent(todoComingFromTheForm.isUrgent());
      todoInDataBase.setDone(todoComingFromTheForm.isDone());
      todoInDataBase.setAssignee(todoComingFromTheForm.getAssignee());
      todoService.addTodo(todoInDataBase); //felülírja a régi todo-t  az újjal, mert ugyanaz az id-jük
    }
    return "redirect:/todo/";
  }

//  @PostMapping("/{todoId}/edit")
//  public String editTodoAssignee(@PathVariable long todoId, @ModelAttribute(value = "assigneeId") String name) {
//    Optional<Todo> todoOptionalInDatabase = todoService.findTodo(todoId);
//    Optional<Assignee> assigneeOptionalInDatabase = assigneeService.findAssigneeByName(name);
//
//    if (todoOptionalInDatabase.isPresent() && assigneeOptionalInDatabase.isPresent()) {
//      Todo todoInDataBase = todoOptionalInDatabase.get();
//      todoInDataBase.setAssignee(assigneeOptionalInDatabase.get());
//      todoService.addTodo(todoInDataBase); //felülírja a régi todo-t  az újjal, mert ugyanaz az id-jük
//    }
//    return "redirect:/todo/";
//  }

  @GetMapping("/{todoId}/details")
  public String detailsTodo(@PathVariable long todoId, Model model) {
    Optional<Todo> todoOptionalInDatabase = todoService.findTodoById(todoId);

    if (todoOptionalInDatabase.isPresent()) {
      model.addAttribute("todo", todoOptionalInDatabase.get());
    }
    return "todo_details";
  }

}

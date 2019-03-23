package com.greenfoxacademy.listingtodoswithassigneesmsql.controllers;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Todo;
import com.greenfoxacademy.listingtodoswithassigneesmsql.services.AssigneeService;
import com.greenfoxacademy.listingtodoswithassigneesmsql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
  public String showTodos(@RequestParam(required = false) Boolean isActive,
                          @RequestParam(required = false) String description,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dueDate, Model model) {
    ArrayList<Todo> filteredTodos;

    if (isActive != null) {
      filteredTodos = todoService.findTodosByDone(!isActive);
    } else {
      filteredTodos = todoService.findTodosByDescriptionAndNameAndDuedate(description, name, dueDate);
    }

    model.addAttribute("description", description);
    model.addAttribute("name", name);
    model.addAttribute("dueDate", dueDate);
    model.addAttribute("todos", filteredTodos);
    model.addAttribute("isActive", isActive);
    return "todo_list";
  }

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
    findTodoAndAddToModel(todoId, model);
    model.addAttribute("assignees", assigneeService.findAllAssignees());
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
      todoInDataBase.setDueDate(todoComingFromTheForm.getDueDate());
      todoService.addTodo(todoInDataBase); //felülírja a régi todo-t  az újjal, mert ugyanaz az id-jük
    }
    return "redirect:/todo/";
  }

  @GetMapping("/{todoId}/details")
  public String detailsTodo(@PathVariable long todoId, Model model) {
    findTodoAndAddToModel(todoId, model);
    return "todo_details";
  }

  private void findTodoAndAddToModel(long id, Model model) {
    Optional<Todo> todoOptionalInDatabase = todoService.findTodoById(id);

    if (todoOptionalInDatabase.isPresent()) {
      model.addAttribute("todo", todoOptionalInDatabase.get());
    } else {
      model.addAttribute("error", "No todo found!");
    }
  }

}

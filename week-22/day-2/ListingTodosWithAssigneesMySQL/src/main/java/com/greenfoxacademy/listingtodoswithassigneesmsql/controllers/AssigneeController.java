package com.greenfoxacademy.listingtodoswithassigneesmsql.controllers;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Assignee;
import com.greenfoxacademy.listingtodoswithassigneesmsql.services.AssigneeService;
import com.greenfoxacademy.listingtodoswithassigneesmsql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/assignee")
public class AssigneeController {

  private AssigneeService assigneeService;
  private TodoService todoService;

  @Autowired
  public AssigneeController(AssigneeService assigneeService, TodoService todoService) {
    this.assigneeService = assigneeService;
    this.todoService = todoService;
  }

  @GetMapping("/")
  public String showAssignees(Model model) {
    model.addAttribute("assignees", assigneeService.findAllAssignees());
    return "assignee_list";
  }

  @GetMapping("/addAssignee")
  public String addAssignee() {
    return "add_assignee";
  }

  @PostMapping("/addAssignee")
  public String addAssignee(@ModelAttribute(value = "name") String name,
                            @ModelAttribute(value = "email") String email) {
    assigneeService.addAssignee(new Assignee(name, email));
    return "redirect:/assignee/";
  }

  @PostMapping("/{assigneeId}/delete")
  public String deleteAssignee(@PathVariable long assigneeId) {
    assigneeService.deleteAssignee(assigneeId);
    return "redirect:/assignee/";
  }

  @GetMapping("/{assigneeId}/edit")
  public String editAssignee(@PathVariable long assigneeId, Model model) {
    findAssigneeAndAddToModel(assigneeId, model);
    return "edit_assignee";
  }

  @PostMapping("/edit")
  public String editAssignee(@ModelAttribute Assignee assigneeComingFromTheForm) {
    Optional<Assignee> assigneeOptionalInDatabase = assigneeService.findAssigneeById(assigneeComingFromTheForm.getAssigneeId());

    if (assigneeOptionalInDatabase.isPresent()) {
      Assignee assigneeInDataBase = assigneeOptionalInDatabase.get();
      assigneeInDataBase.setName(assigneeComingFromTheForm.getName());
      assigneeService.addAssignee(assigneeInDataBase); //felülírja a régi assignee-t  az újjal, mert ugyanaz az id-jük
    }
    return "redirect:/assignee/";
  }

  @GetMapping("/{assigneeId}/details/{from}")
  public String detailsAssignee(@PathVariable long assigneeId, @PathVariable int from, Model model) {
    findAssigneeAndAddToModel(assigneeId, model);
//      model.addAttribute("todos", todoService.findTodosByAssignee(assigneeInDatabase));
    model.addAttribute("todos", todoService.findTodosByAssignee(assigneeId));
    model.addAttribute("from", from);
    return "assignee_details";
  }

  private void findAssigneeAndAddToModel(long id, Model model) {
    Optional<Assignee> assigneeOptionalInDatabase = assigneeService.findAssigneeById(id);

    if (assigneeOptionalInDatabase.isPresent()) {
      model.addAttribute("assignee", assigneeOptionalInDatabase.get());
    } else {
      model.addAttribute("error", "No assignee found!");
    }
  }

}

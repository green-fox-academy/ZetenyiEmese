package com.greenfoxacademy.listingtodoswithassigneesmsql.services;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Assignee;
import com.greenfoxacademy.listingtodoswithassigneesmsql.repositories.AssigneeRepository;
import com.greenfoxacademy.listingtodoswithassigneesmsql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AssigneeService {

  private AssigneeRepository assigneeRepository;
  private TodoRepository todoRepository;

  @Autowired
  public AssigneeService(AssigneeRepository assigneeRepository, TodoRepository todoRepository) {
    this.assigneeRepository = assigneeRepository;
    this.todoRepository = todoRepository;
  }

  public void addAssignee(Assignee assignee) {
    assigneeRepository.save(assignee);
  }

  public void deleteAssignee(long assigneeId) {
    if (todoRepository.findTodosByAssignee_AssigneeId(assigneeId).isEmpty()) {
      assigneeRepository.deleteById(assigneeId);
    }
  }

  public ArrayList<Assignee> findAllAssignees() {
    ArrayList<Assignee> assignees = new ArrayList<>();
    assigneeRepository.findAll().forEach(assignees::add);
    return assignees;
  }

  public Optional<Assignee> findAssigneeById(long assigneeId){
    return assigneeRepository.findById(assigneeId);
  }

  public Optional<Assignee> findAssigneeByName(String name) {
    return assigneeRepository.findAssigneeByName(name);
  }

}

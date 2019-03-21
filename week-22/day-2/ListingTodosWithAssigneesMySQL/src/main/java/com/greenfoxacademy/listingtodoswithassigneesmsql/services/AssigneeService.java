package com.greenfoxacademy.listingtodoswithassigneesmsql.services;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Assignee;
import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Todo;
import com.greenfoxacademy.listingtodoswithassigneesmsql.repositories.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AssigneeService {

  private AssigneeRepository assigneeRepository;

  @Autowired
  public AssigneeService(AssigneeRepository assigneeRepository) {
    this.assigneeRepository = assigneeRepository;
  }

  public void addAssignee(Assignee assignee) {
    assigneeRepository.save(assignee);
  }

  public void deleteAssignee(long assigneeId) {
    assigneeRepository.deleteById(assigneeId);
  }

  public ArrayList<Assignee> findAllAssignees() {
    ArrayList<Assignee> assignees = new ArrayList<>();
    assigneeRepository.findAll().forEach(assignees::add);
    return assignees;
  }

  public Optional<Assignee> findAssignee(long assigneeId){
    return assigneeRepository.findById(assigneeId);
  }

  public Optional<Assignee> findAssigneeByName(String name) {
    return assigneeRepository.findAssigneeByName(name);
  }

}

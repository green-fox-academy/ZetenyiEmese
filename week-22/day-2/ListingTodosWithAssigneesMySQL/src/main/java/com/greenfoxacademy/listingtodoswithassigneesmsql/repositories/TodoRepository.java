package com.greenfoxacademy.listingtodoswithassigneesmsql.repositories;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Assignee;
import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  public ArrayList<Todo> findTodoByDone(boolean done);
  public ArrayList<Todo> findTodoByUrgent(boolean urgent);
  public ArrayList<Todo> findTodosByDescriptionContaining(String description);
//  public ArrayList<Todo> findTodosByAssignee(Assignee assignee);
  public ArrayList<Todo> findTodosByAssignee_AssigneeId(long assigneeId);
  public ArrayList<Todo> findTodosByAssignee_NameContaining(String name);
  public ArrayList<Todo> findTodosByDescriptionContainingAndAssignee_NameContaining(String description, String name);
  public ArrayList<Todo> findTodosByDueDate(LocalDate duedate);
}

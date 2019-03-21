package com.greenfoxacademy.listingtodoswithassigneesmsql.repositories;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Assignee;
import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  public ArrayList<Todo> findTodoByDone(boolean done);
  public ArrayList<Todo> findTodoByUrgent(boolean urgent);
  public ArrayList<Todo> findTodosByDescriptionContaining(String desc);
//  public ArrayList<Todo> findTodosByAssignee(Assignee assignee);
  public ArrayList<Todo> findTodosByAssignee_AssigneeId(long assigneeId);
  public ArrayList<Todo> findTodosByAssignee_NameContaining(String assigneeNamePart);
  public ArrayList<Todo> findTodosByDescriptionContainingAndAssignee_NameContaining(String descriptionPart, String assigneeNamePart);
}

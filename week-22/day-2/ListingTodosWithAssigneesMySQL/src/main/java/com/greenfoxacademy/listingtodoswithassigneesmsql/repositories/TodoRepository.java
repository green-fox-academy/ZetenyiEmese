package com.greenfoxacademy.listingtodoswithassigneesmsql.repositories;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  public ArrayList<Todo> findByDone(boolean done);
  public ArrayList<Todo> findByUrgent(boolean urgent);
  public ArrayList<Todo> findTodosByDescriptionContaining(String desc);
}

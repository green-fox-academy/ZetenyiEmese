package com.greenfoxacademy.listingtodosmysql.repositories;

import com.greenfoxacademy.listingtodosmysql.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  public ArrayList<Todo> findAll();
  public ArrayList<Todo> findByDone(boolean done);
  public ArrayList<Todo> findByUrgent(boolean urgent);
}

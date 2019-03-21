package com.greenfoxacademy.listingtodoswithassigneesmsql.services;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Assignee;
import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Todo;
import com.greenfoxacademy.listingtodoswithassigneesmsql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TodoService {

  private TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public void addTodo(Todo todo) {
    todoRepository.save(todo);
  }

  public void deleteTodo(long todoId) {
    todoRepository.deleteById(todoId);
  }

  public ArrayList<Todo> findAllTodos() {
    ArrayList<Todo> todos = new ArrayList<>();
    todoRepository.findAll().forEach(todos::add);
    return todos;
  }

  public Optional<Todo> findTodoById(long todoId){
    return todoRepository.findById(todoId);
  }

  public ArrayList<Todo> findTodoByDone(boolean done) {
    return todoRepository.findTodoByDone(done);
  }

  public ArrayList<Todo> findTodosByDescriptionContaining(String descriptionPart) {
    return todoRepository.findTodosByDescriptionContaining(descriptionPart);
  }

//  public ArrayList<Todo> findTodosByAssignee(Assignee assignee) {
//    return todoRepository.findTodosByAssignee(assignee);
//  }

  public ArrayList<Todo> findTodosByAssignee(long assigneeId) {
    return todoRepository.findTodosByAssignee_AssigneeId(assigneeId);
  }

}

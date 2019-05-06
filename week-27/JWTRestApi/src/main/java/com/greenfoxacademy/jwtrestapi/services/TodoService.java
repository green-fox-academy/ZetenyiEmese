package com.greenfoxacademy.jwtrestapi.services;

import com.greenfoxacademy.jwtrestapi.models.JsonTodo;
import com.greenfoxacademy.jwtrestapi.models.Todo;
import com.greenfoxacademy.jwtrestapi.models.User;
import com.greenfoxacademy.jwtrestapi.repositories.TodoRepository;
import com.greenfoxacademy.jwtrestapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoService {

  private TodoRepository todoRepository;
  private UserRepository userRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
    this.todoRepository = todoRepository;
    this.userRepository = userRepository;
  }

  public void saveTodo(String username, JsonTodo jsonTodo){
    if (userRepository.findUserByUsername(username).isPresent() && isJsonTodoValid(jsonTodo)) {
      User user = userRepository.findUserByUsername(username).get();
      Todo newTodo = new Todo(jsonTodo.getDescription(), user);
      todoRepository.save(newTodo);
    }
  }

  public ArrayList<Todo> findTodosByUser(String username) {
    return todoRepository.findTodosByAssignee_Username(username);
  }

  private boolean isJsonTodoValid(JsonTodo jsonTodo){
    return jsonTodo != null && jsonTodo.getDescription() != null && !jsonTodo.getDescription().isEmpty();
  }

}

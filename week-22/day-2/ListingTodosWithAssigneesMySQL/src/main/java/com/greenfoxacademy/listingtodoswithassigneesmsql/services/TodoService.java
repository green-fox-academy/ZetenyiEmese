package com.greenfoxacademy.listingtodoswithassigneesmsql.services;

import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Assignee;
import com.greenfoxacademy.listingtodoswithassigneesmsql.models.Todo;
import com.greenfoxacademy.listingtodoswithassigneesmsql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

  public Optional<Todo> findTodoById(long todoId) {
    return todoRepository.findById(todoId);
  }

  public ArrayList<Todo> findTodoByDone(boolean done) {
    return todoRepository.findTodoByDone(done);
  }

  public ArrayList<Todo> findTodosByDescriptionContaining(String description) {
    return todoRepository.findTodosByDescriptionContaining(description);
  }

//  public ArrayList<Todo> findTodosByAssignee(Assignee assignee) {
//    return todoRepository.findTodosByAssignee(assignee);
//  }

  public ArrayList<Todo> findTodosByAssignee(long assigneeId) {
    return todoRepository.findTodosByAssignee_AssigneeId(assigneeId);
  }

  public ArrayList<Todo> findTodosByAssigneeNameContaining(String name) {
    return todoRepository.findTodosByAssignee_NameContaining(name);
  }

  public ArrayList<Todo> findTodosByDescriptionContainingAndAssigneeNameContaining(String description, String name) {
    return todoRepository.findTodosByDescriptionContainingAndAssignee_NameContaining(description, name);
  }

  public ArrayList<Todo> findTodosByDueDate(LocalDate duedate) {
    return todoRepository.findTodosByDueDate(duedate);
  }

  public ArrayList<Todo> findTodosByDescriptionAndNameAndDuedate(String description, String name, LocalDate duedate) {
    ArrayList<Todo> resultFilteredTodos = findAllTodos();

    if (description != null && !description.isEmpty()) {
      resultFilteredTodos = todoRepository.findTodosByDescriptionContaining(description);
    }

    if (name != null && !name.isEmpty()) {
      resultFilteredTodos = findTodosBy(name, resultFilteredTodos);
    }

    if (duedate != null) {
      resultFilteredTodos = findTodosBy(duedate, resultFilteredTodos);
    }

    return resultFilteredTodos;
  }

  private ArrayList<Todo> findTodosBy(String name, ArrayList<Todo> todos) {
    ArrayList<Todo> searchedTodos = new ArrayList<>();

    for (Todo todo : todos) {
      if (todo.getAssignee() != null && todo.getAssignee().getName().toLowerCase().contains(name.toLowerCase())) {
        searchedTodos.add(todo);
      }
    }
    return searchedTodos;
  }

  private ArrayList<Todo> findTodosBy(LocalDate date, ArrayList<Todo> todos) {
    ArrayList<Todo> searchedTodos = new ArrayList<>();

    for (Todo todo : todos) {
      if (todo.getDueDate() != null && todo.getDueDate().equals(date)) {
        searchedTodos.add(todo);
      }
    }
    return searchedTodos;
  }

}

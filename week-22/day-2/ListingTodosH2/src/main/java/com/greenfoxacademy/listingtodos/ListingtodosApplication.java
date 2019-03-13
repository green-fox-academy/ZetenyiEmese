package com.greenfoxacademy.listingtodos;

import com.greenfoxacademy.listingtodos.models.Todo;
import com.greenfoxacademy.listingtodos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ListingtodosApplication implements CommandLineRunner {

  private TodoRepository todoRepository;

  @Autowired
  public ListingtodosApplication(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(ListingtodosApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoRepository.save(new Todo("Learn Object Relational Mapping"));
    todoRepository.save(new Todo("Finish H2 workshop"));
    todoRepository.save(new Todo("Cook dinner"));
    todoRepository.save(new Todo("Walk the dog"));
    todoRepository.save(new Todo("Sleep a LOT!"));
  }

}

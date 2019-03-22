package com.greenfoxacademy.listingtodoswithassigneesmsql.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long todoId;

  private String description;
  private LocalDateTime createdAt;
  private boolean urgent;
  private boolean done;

  //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dueDate;

  @ManyToOne
  @JoinColumn(name = "assigneeId")
  private Assignee assignee;

  //az üres konstruktor kell az adatbázis miatt:
  public Todo() {
  }

  public Todo(String description) {
    this.description = description;
    createdAt = LocalDateTime.now();
  }

  //a getterek is kellenek az adatbázis miatt:
  public long getTodoId() {
    return todoId;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public boolean isUrgent() {
    return urgent;
  }

  public boolean isDone() {
    return done;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  //ezek a setterek kellenek az editáláshoz, amikor a formból érkező todo-t a Spring össze akarja állítani
  public void setTodoId(long todoId) {
    this.todoId = todoId;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }

}
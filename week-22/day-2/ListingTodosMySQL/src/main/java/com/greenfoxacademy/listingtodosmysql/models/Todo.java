package com.greenfoxacademy.listingtodosmysql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String description;
  private LocalDateTime createdAt;
  private boolean urgent;
  private boolean done;

  //az üres konstruktor kell az adatbázis miatt:
  public Todo() {
  }

  public Todo(String description) {
    this.description = description;
    createdAt = LocalDateTime.now();
  }

  //a getterek is kellenek az adatbázis miatt:
  public long getId() {
    return id;
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

  //ezek a setterek kellenek az editáláshoz, amikor a formból érkező todo-t a Spring össze akarja állítani
  public void setId(long id) {
    this.id = id;
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

}

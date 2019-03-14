package com.greenfoxacademy.listingtodosmysql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String description;
  private boolean urgent;
  private boolean done;

  //az üres konstruktor kell az adatbázis miatt:
  public Todo() {
  }

  public Todo(String description) {
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public boolean isUrgent() {
    return urgent;
  }

  public boolean isDone() {
    return done;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

}

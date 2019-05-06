package com.greenfoxacademy.jwtrestapi.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;
  private LocalDateTime createdAt;
  private boolean done;

  @ManyToOne(optional = false)
  private User assignee;

  public Todo() {
  }

  public Todo(String description, User assignee) {
    this.description = description;
    this.assignee = assignee;
    createdAt = LocalDateTime.now();
    done = false;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public User getAssignee() {
    return assignee;
  }

  public void setAssignee(User assignee) {
    this.assignee = assignee;
  }

}

package com.greenfoxacademy.redditapp.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;
  private String url;
  private LocalDateTime createdAt;
  private int vote;

  @ManyToOne(optional = false)
  @JoinColumn(name = "userId")
  private User user;

  public Post() {
  }

  public Post(String title, String url, User user) {
    this.title = title;
    this.url = url;
    this.user = user;
    createdAt = LocalDateTime.now();
    vote = 50;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public int getVote() {
    return vote;
  }

  public User getUser() {
    return user;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setVote(int vote) {
    this.vote = vote;
  }

  public void setUser(User user) {
    this.user = user;
  }

}

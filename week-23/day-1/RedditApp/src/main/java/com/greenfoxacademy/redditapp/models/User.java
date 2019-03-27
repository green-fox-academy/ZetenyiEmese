package com.greenfoxacademy.redditapp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String username;
  private String password;
  private String email;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "userId")
  private List<Post> posts;

  public User() {
  }

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
    posts = new ArrayList<>();
  }

  public long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

}

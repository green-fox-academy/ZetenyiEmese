package com.greenfoxacademy.jwtrestapi.models;

public class JsonUser{

  private String username;
  private String password;

  public JsonUser() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}

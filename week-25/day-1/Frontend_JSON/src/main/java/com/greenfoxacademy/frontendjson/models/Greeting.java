package com.greenfoxacademy.frontendjson.models;

public class Greeting {

  private String welcome_message;

  public Greeting(String name, String title) {
    this.welcome_message = createWelcomeMessage(name, title);
  }

  private String createWelcomeMessage(String name, String title) {
    return "Oh, hi there " + name + ", my dear " + title + "!";
  }

  public String getWelcome_message() {
    return welcome_message;
  }

  public void setWelcome_message(String welcome_message) {
    this.welcome_message = welcome_message;
  }

}

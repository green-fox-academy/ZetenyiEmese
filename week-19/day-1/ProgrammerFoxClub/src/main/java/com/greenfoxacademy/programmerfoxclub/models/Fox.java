package com.greenfoxacademy.programmerfoxclub.models;

import java.util.ArrayList;

public class Fox {

  private String name;
  private String imageURL;
  private String food;
  private String drink;
  private ArrayList<String> tricks;
  private ArrayList<String> actions;

  public Fox() {
  }

  public Fox(String name) {
    this(name, "");
  }

  public Fox(String name, String imageURL) {
    this.name = name;
    this.imageURL = imageURL;
    food = "grass";
    drink = "water";
    tricks = new ArrayList<>();
    actions = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public String getImageURL() {
    return imageURL;
  }

  public String getFood() {
    return food;
  }

  public String getDrink() {
    return drink;
  }

  public ArrayList<String> getTricks() {
    return tricks;
  }

  public ArrayList<String> getActions() {
    return actions;
  }

  public void setFood(String food) {
    this.food = food;
  }

  public void setDrink(String drink) {
    this.drink = drink;
  }

  public int countTricks() {
    return tricks.size();
  }

}

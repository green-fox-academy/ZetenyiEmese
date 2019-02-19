package com.greenfoxacademy.programmerfoxclub.models;

import java.util.ArrayList;

public class Fox {

  private String name;
  private String food;
  private String drink;
  private ArrayList<String> tricks;

  public Fox(String name) {
    this.name = name;
    tricks = new ArrayList<>();
  }

  public String getName() {
    return name;
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

  public void setName(String name) {
    this.name = name;
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

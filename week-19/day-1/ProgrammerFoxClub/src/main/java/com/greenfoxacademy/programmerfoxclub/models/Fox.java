package com.greenfoxacademy.programmerfoxclub.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Fox {

  private static Integer energyBurnRate = 2;
  private String name;
  private String imageURL;
  private String food;
  private String drink;
  private Long startEnergyLevel;
  private LocalDateTime feedTime;
  private ArrayList<String> tricks;
  private ArrayList<String> actions;

//  public Fox() {
//  }

//  public Fox(String name) {
//    this(name, null, null, null);
//  }

  public Fox(String name, String imageURL, String food, Long startEnergyLevel, String drink) {
    this.name = name;
    this.imageURL = imageURL;
    this.food = food;
    this.drink = drink;
    this.startEnergyLevel = startEnergyLevel;
    feedTime = LocalDateTime.now();
    tricks = new ArrayList<>();
    actions = new ArrayList<>();
  }

  public static Integer getEnergyBurnRate() {
    return energyBurnRate;
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

  public Long getStartEnergyLevel() {
    return startEnergyLevel;
  }

  public LocalDateTime getFeedTime() {
    return feedTime;
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

  public void setStartEnergyLevel(Long startEnergyLevel) {
    this.startEnergyLevel = startEnergyLevel;
  }

  public void setFeedTime(LocalDateTime feedTime) {
    this.feedTime = feedTime;
  }

  public int countTricks() {
    return tricks.size();
  }

}

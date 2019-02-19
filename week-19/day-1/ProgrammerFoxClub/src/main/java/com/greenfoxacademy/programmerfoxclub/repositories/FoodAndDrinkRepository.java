package com.greenfoxacademy.programmerfoxclub.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class FoodAndDrinkRepository {

  private ArrayList<String> foods;
  private ArrayList<String> drinks;

  public FoodAndDrinkRepository() {
    this.foods = new ArrayList<>();
    foods.add("pizza");
    foods.add("salat");
    foods.add("apple pie");
    foods.add("jacket potato");
    foods.add("steak");
    foods.add("pasta");
    foods.add("risotto");

    this.drinks = new ArrayList<>();
    drinks.add("water");
    drinks.add("lemonade");
    drinks.add("juice");
    drinks.add("beer");
    drinks.add("wine");
    drinks.add("whiskey");
    drinks.add("rum");
  }

  public ArrayList<String> findAllFoods() {
    return foods;
  }

  public ArrayList<String> findAllDrinks() {
    return drinks;
  }

}

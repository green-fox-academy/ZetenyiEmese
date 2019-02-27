package com.greenfoxacademy.programmerfoxclub.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class FoodAndDrinkRepository {

  private HashMap<String, Integer> foods;
  private ArrayList<String> drinks;

  public FoodAndDrinkRepository() {
    this.foods = new HashMap<>();
    foods.put("pizza", 400);
    foods.put("salad", 100);
    foods.put("apple pie", 200);
    foods.put("jacket potato", 250);
    foods.put("steak", 300);
    foods.put("pasta", 400);
    foods.put("risotto", 350);

    this.drinks = new ArrayList<>();
    drinks.add("water");
    drinks.add("lemonade");
    drinks.add("juice");
    drinks.add("beer");
    drinks.add("wine");
    drinks.add("whiskey");
    drinks.add("rum");
  }

  public HashMap<String, Integer> findAllFoods() {
    return foods;
  }

  public ArrayList<String> findAllDrinks() {
    return drinks;
  }

  public Integer findEnergyContent(String foodName) {
    return foods.get(foodName);
  }

}

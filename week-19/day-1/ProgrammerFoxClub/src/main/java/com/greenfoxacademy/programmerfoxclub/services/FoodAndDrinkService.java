package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.repositories.FoodAndDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class FoodAndDrinkService {

  private FoodAndDrinkRepository foodAndDrinkRepository;

  @Autowired
  public FoodAndDrinkService(FoodAndDrinkRepository foodAndDrinkRepository) {
    this.foodAndDrinkRepository = foodAndDrinkRepository;
  }

  public ArrayList<String> findAllFoods() {
    HashMap<String, Integer> foodHashMap = foodAndDrinkRepository.findAllFoods();
    ArrayList<String> foods = new ArrayList<>();

    for (String foodName : foodHashMap.keySet()) {
      foods.add(foodName);
    }
    return foods;
  }

  public ArrayList<String> findAllDrinks() {
    return foodAndDrinkRepository.findAllDrinks();
  }

}

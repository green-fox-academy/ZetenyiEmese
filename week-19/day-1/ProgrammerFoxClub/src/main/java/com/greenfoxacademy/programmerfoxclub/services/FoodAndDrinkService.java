package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.repositories.FoodAndDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FoodAndDrinkService {

  private FoodAndDrinkRepository foodAndDrinkRepository;

  @Autowired
  public FoodAndDrinkService(FoodAndDrinkRepository foodAndDrinkRepository) {
    this.foodAndDrinkRepository = foodAndDrinkRepository;
  }

  public ArrayList<String> findAllFoods() {
    return foodAndDrinkRepository.findAllFoods();
  }

  public ArrayList<String> findAllDrinks() {
    return foodAndDrinkRepository.findAllDrinks();
  }

}

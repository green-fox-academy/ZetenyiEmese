package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


@Service
public class FoxService {

  private FoxRepository foxRepository;

  @Autowired
  public FoxService(FoxRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  public Fox findOrCreateFoxByName(String name) {
    Fox fox;
    if (foxRepository.findAll().containsKey(name)) {
      fox = foxRepository.findByName(name);
    } else {
      fox = new Fox(name);
      foxRepository.save(fox);
    }
    return fox;
  }

  public Fox findFoxByName(String name) {
    return foxRepository.findByName(name);
  }

  public void setFoodAndDrinkForFox(String name, String newFood, String newDrink) {
    Fox fox = foxRepository.findByName(name);
    setFoodForFox(fox, newFood);
    setDrinkForFox(fox, newDrink);
  }

  private void setFoodForFox(Fox fox, String newFood) {
    String pastFood = fox.getFood();
    fox.setFood(newFood);
    addFoodOrDrinkActionForFox(fox, pastFood, newFood, true);
  }

  private void setDrinkForFox(Fox fox, String newDrink) {
    String pastDrink = fox.getDrink();
    fox.setDrink(newDrink);
    addFoodOrDrinkActionForFox(fox, pastDrink, newDrink, false);
  }

  private void addFoodOrDrinkActionForFox(Fox fox, String pastFood, String newFood, boolean isFood) {
    ArrayList<String> actions = fox.getActions();
    String action = createFormattedDateTime() +
                    (isFood ? ": Food" : ": Drink") + " has been changed from: " + pastFood + " to: "+ newFood;
    actions.add(action);
  }

  public void addTrickForFox(String name, String newTrick) {
    Fox fox = foxRepository.findByName(name);
    ArrayList<String> tricks = fox.getTricks();

    if (!tricks.contains(newTrick)) {
      tricks.add(newTrick);
      addTrickActionForFox(fox, newTrick);
    }
  }

  private void addTrickActionForFox(Fox fox, String newTrick) {
    ArrayList<String> actions = fox.getActions();
    String action = createFormattedDateTime() + ": Learned to: " + newTrick;
    actions.add(action);
  }

  private String createFormattedDateTime() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = LocalDateTime.now().format(formatter);
    return formattedDateTime;
  }

}

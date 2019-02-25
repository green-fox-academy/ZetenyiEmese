package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;


@Service
public class FoxService {

  private FoxRepository foxRepository;

  @Autowired
  public FoxService(FoxRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  public Fox createFoxByName(String name, String imageURL) {
    Fox fox;
    if (foxRepository.findAll().containsKey(name)) {
      fox = foxRepository.findByName(name);
    } else {
      fox = new Fox(name, imageURL);
      foxRepository.save(fox);
    }
    return fox;
  }

  public boolean checkFoxByName(String name) {
    return foxRepository.findAll().containsKey(name);
  }

  public Fox findFoxByName(String name) {
    return foxRepository.findByName(name);
  }

  public ArrayList<Fox> findAllFoxes() {
    HashMap<String, Fox> foxHashMap = foxRepository.findAll();
    ArrayList<Fox> foxes = new ArrayList<>();

    for (String foxName : foxHashMap.keySet()) {
      foxes.add(foxHashMap.get(foxName));
    }
    return foxes;
  }
//  public Fox findOrCreateFoxByName(String name) {
//    Fox fox;
//    if (foxRepository.findAll().containsKey(name)) {
//      fox = foxRepository.findByName(name);
//    } else {
//      fox = new Fox(name);
//      foxRepository.save(fox);
//    }
//    return fox;
//  }

  public void setFoodAndDrinkForFox(String name, String newFood, String newDrink) {
    Fox fox = foxRepository.findByName(name);
    setFoodForFox(fox, newFood);
    setDrinkForFox(fox, newDrink);
  }

  private void setFoodForFox(Fox fox, String newFood) {
    String currentFood = fox.getFood();
    fox.setFood(newFood);
    String action = createFormattedDateTime() + ": Food has been changed from: " + currentFood + " to: " + newFood;
    fox.getActions().add(action);
  }

  private void setDrinkForFox(Fox fox, String newDrink) {
    String currentDrink = fox.getDrink();
    fox.setDrink(newDrink);
    String action = createFormattedDateTime() + ": Drink has been changed from: " + currentDrink + " to: " + newDrink;
    fox.getActions().add(action);
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
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss");
    String formattedDateTime = LocalDateTime.now().format(formatter);
    return formattedDateTime;
  }

  public ArrayList<String> findLastActions(String name) {
    Fox fox = foxRepository.findByName(name);
    ArrayList<String> actions = fox.getActions();
    ArrayList<String> lastActions = new ArrayList<>();
    int size = actions.size();

    if (size >= 5) {
      for (int i = 5; i > 0; i--) {
        lastActions.add(actions.get(size - i));
      }
    } else {
      lastActions = actions;
    }

    return lastActions;
  }

  public ArrayList<String> findFoxImages() {
    HashMap<String, Fox> foxHashMap = foxRepository.findAll();
    ArrayList<String> occupiedImages = new ArrayList<>();

    for (String foxName : foxHashMap.keySet()) {
      Fox fox = foxHashMap.get(foxName);
      occupiedImages.add(fox.getImageURL());
    }
    return occupiedImages;
  }

}

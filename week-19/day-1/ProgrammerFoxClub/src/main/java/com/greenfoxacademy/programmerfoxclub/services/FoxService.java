package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.repositories.FoodAndDrinkRepository;
import com.greenfoxacademy.programmerfoxclub.repositories.FoxRepository;
import com.greenfoxacademy.programmerfoxclub.repositories.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;


@Service
public class FoxService {

  private FoxRepository foxRepository;
  private FoodAndDrinkRepository foodAndDrinkRepository;
  private TrickRepository trickRepository;

  @Autowired
  public FoxService(FoxRepository foxRepository, FoodAndDrinkRepository foodAndDrinkRepository, TrickRepository trickRepository) {
    this.foxRepository = foxRepository;
    this.foodAndDrinkRepository = foodAndDrinkRepository;
    this.trickRepository = trickRepository;
  }

  public Fox createFoxByName(String name, String imageURL) {
    Fox fox;
    if (foxRepository.findAll().containsKey(name)) {
      fox = foxRepository.findByName(name);
    } else {
      fox = new Fox(name, imageURL, "salad", 100L); //TODO!
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

  public boolean isFoxHungry(String name) {
    Fox fox = findFoxByName(name);
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime feedTime = fox.getFeedTime();
    long duration = Duration.between(feedTime, now).getSeconds();
    return fox.getStartEnergyLevel() - duration * Fox.getEnergyBurnRate() < 10;
  }

  public void setFoodAndDrinkForFox(String name, String newFood, String newDrink) {
    Fox fox = foxRepository.findByName(name);
    setFoodForFox(fox, newFood);
    setDrinkForFox(fox, newDrink);
  }

  private void setFoodForFox(Fox fox, String newFood) {
    String currentFood = fox.getFood();
    fox.setFood(newFood);
    setStartEnergyLevelForFox(fox, newFood);
    fox.setFeedTime(LocalDateTime.now());
    String action = createFormattedDateTime() + ": Food has been changed from: " + currentFood + " to: " + newFood;
    fox.getActions().add(action);
  }

  private void setStartEnergyLevelForFox(Fox fox, String newFood) {
    long currentEnergyLevel = currentEnergyLevel(fox);
    if (currentEnergyLevel < 0) {
      currentEnergyLevel = 0;
    }
    fox.setStartEnergyLevel(currentEnergyLevel + foodAndDrinkRepository.findEnergyContent(newFood));
  }

  private void setDrinkForFox(Fox fox, String newDrink) {
    String currentDrink = fox.getDrink();
    fox.setDrink(newDrink);
    String action = createFormattedDateTime() + ": Drink has been changed from: " + currentDrink + " to: " + newDrink;
    fox.getActions().add(action);
  }

  public boolean addTrickForFox(String name, String newTrick) {
    Fox fox = foxRepository.findByName(name);
    ArrayList<String> tricks = fox.getTricks();

    long currentEnergyLevel = currentEnergyLevel(fox);
    int trickEnergyNeed = trickRepository.findEnergyNeed(newTrick);
    boolean isFoxEnoughEnergic = currentEnergyLevel > trickEnergyNeed;

    if (!tricks.contains(newTrick) && isFoxEnoughEnergic) {
      tricks.add(newTrick);
      fox.setStartEnergyLevel(fox.getStartEnergyLevel() - trickEnergyNeed);
      addTrickActionForFox(fox, newTrick);
      return true;
    }
    return false;
  }

  private void addTrickActionForFox(Fox fox, String newTrick) {
    ArrayList<String> actions = fox.getActions();
    String action = createFormattedDateTime() + ": Learned to: " + newTrick;
    actions.add(action);
  }

  public long currentEnergyLevel(Fox fox) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime previousFeedTime = fox.getFeedTime();
    long duration = Duration.between(previousFeedTime, now).getSeconds();
    long currentEnergyLevel = fox.getStartEnergyLevel() - duration * Fox.getEnergyBurnRate();
    return currentEnergyLevel;
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

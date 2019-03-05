package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.repositories.FoodAndDrinkRepository;
import com.greenfoxacademy.programmerfoxclub.repositories.FoxRepository;
import com.greenfoxacademy.programmerfoxclub.repositories.ImageRepository;
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
  private ImageRepository imageRepository;

  @Autowired
  public FoxService(FoxRepository foxRepository, FoodAndDrinkRepository foodAndDrinkRepository,
                    TrickRepository trickRepository, ImageRepository imageRepository) {
    this.foxRepository = foxRepository;
    this.foodAndDrinkRepository = foodAndDrinkRepository;
    this.trickRepository = trickRepository;
    this.imageRepository = imageRepository;
  }

  public Fox createFoxByName(String name, String imageURL) {
    Fox fox;
    if (foxRepository.findAll().containsKey(name)) {
      fox = foxRepository.findByName(name);
    } else {
      fox = new Fox(name, imageURL, "salad", (long) foodAndDrinkRepository.findEnergyContent("salad"), "water");
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
    return currentEnergyLevel(name) < 10;
  }

  public long currentEnergyLevel(String name) {
    Fox fox = findFoxByName(name);
    long currentEnergyLevel = fox.getStartEnergyLevel() - duration(fox) * Fox.getEnergyBurnRate();
    return currentEnergyLevel > 0 ? currentEnergyLevel : 0;
  }

  private long duration(Fox fox) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime previousFeedTime = fox.getFeedTime();
    long duration = Duration.between(previousFeedTime, now).getSeconds();
    return duration;
  }

  public void setFoodAndDrinkForFox(String name, String newFood, String newDrink) {
    setFoodForFox(name, newFood);
    setDrinkForFox(name, newDrink);
  }

  private void setFoodForFox(String name, String newFood) {
    Fox fox = findFoxByName(name);
    String currentFood = fox.getFood();
    fox.setFood(newFood);
    fox.setStartEnergyLevel(currentEnergyLevel(name) + foodAndDrinkRepository.findEnergyContent(newFood));
    fox.setFeedTime(LocalDateTime.now());
    addFoodActionForFox(fox, currentFood, newFood);
  }

  private void setDrinkForFox(String name, String newDrink) {
    Fox fox = findFoxByName(name);
    String currentDrink = fox.getDrink();
    fox.setDrink(newDrink);
    addDrinkActionForFox(fox, currentDrink, newDrink);
  }

  public boolean addTrickForFox(String name, String newTrick) {
    Fox fox = findFoxByName(name);
    ArrayList<String> tricks = fox.getTricks();

    long currentEnergyLevel = currentEnergyLevel(name);
    int trickEnergyNeed = trickRepository.findEnergyNeed(newTrick);
    boolean hasFoxEnoughEnergy = currentEnergyLevel > trickEnergyNeed;

    if (!tricks.contains(newTrick) && hasFoxEnoughEnergy) {
      tricks.add(newTrick);
      fox.setStartEnergyLevel(fox.getStartEnergyLevel() - trickEnergyNeed);
      addTrickActionForFox(fox, newTrick);
      return true;
    }
    return false;
  }

  private void addFoodActionForFox(Fox fox, String currentFood, String newFood) {
    ArrayList<String> actions = fox.getActions();
    String action = createFormattedDateTime() + ": Food has been changed from: " + currentFood + " to: " + newFood;
    actions.add(action);
  }

  private void addDrinkActionForFox(Fox fox, String currentDrink, String newDrink) {
    ArrayList<String> actions = fox.getActions();
    String action = createFormattedDateTime() + ": Drink has been changed from: " + currentDrink + " to: " + newDrink;
    actions.add(action);
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
    Fox fox = findFoxByName(name);
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

  public ArrayList<String> findFreeImages() {
    ArrayList<String> occupiedImages = findFoxImages();
    ArrayList<String> allImages = imageRepository.findAll();
    ArrayList<String> freeImages = new ArrayList<>();

    for (String image : allImages) {
      if (!occupiedImages.contains(image)) {
        freeImages.add(image);
      }
    }
    return freeImages;
  }

  private ArrayList<String> findFoxImages() {
    HashMap<String, Fox> foxHashMap = foxRepository.findAll();
    ArrayList<String> occupiedImages = new ArrayList<>();

    for (String foxName : foxHashMap.keySet()) {
      Fox fox = foxHashMap.get(foxName);
      occupiedImages.add(fox.getImageURL());
    }
    return occupiedImages;
  }

}

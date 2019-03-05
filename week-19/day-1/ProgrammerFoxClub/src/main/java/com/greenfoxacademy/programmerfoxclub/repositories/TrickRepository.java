package com.greenfoxacademy.programmerfoxclub.repositories;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class TrickRepository {

  private HashMap<String, Integer> tricks;

  public TrickRepository() {
    this.tricks = new HashMap<>();
    tricks.put("write HTML", 150);
    tricks.put("code in Java", 300);
    tricks.put("knit pullover", 150);
    tricks.put("make pizza", 100);
    tricks.put("make cheesecake", 100);
    tricks.put("play the guitar", 300);
    tricks.put("climb a tree", 50);
    tricks.put("walk on the Moon", 500);
    tricks.put("dance with you", 150);
    tricks.put("speak English", 300);
  }

  public HashMap<String, Integer> findAll() {
    return tricks;
  }

  public Integer findEnergyNeed(String trick) {
    return tricks.get(trick);
  }

}

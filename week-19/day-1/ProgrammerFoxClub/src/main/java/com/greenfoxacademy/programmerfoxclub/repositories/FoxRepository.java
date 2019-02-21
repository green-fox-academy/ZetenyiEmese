package com.greenfoxacademy.programmerfoxclub.repositories;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class FoxRepository {

  private HashMap<String, Fox> foxes;

  public FoxRepository() {
    this.foxes = new HashMap<>();
  }

  public void save(Fox newFox) {
    foxes.put(newFox.getName(), newFox);
  }

  public HashMap<String, Fox> findAll() {
    return foxes;
  }

  public Fox findByName(String foxName) {
    return foxes.get(foxName);
  }

}

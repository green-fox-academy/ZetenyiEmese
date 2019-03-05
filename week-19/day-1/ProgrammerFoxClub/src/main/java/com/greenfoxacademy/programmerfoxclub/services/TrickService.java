package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.repositories.FoxRepository;
import com.greenfoxacademy.programmerfoxclub.repositories.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class TrickService {

  private TrickRepository trickRepository;
  private FoxRepository foxRepository;

  @Autowired
  public TrickService(TrickRepository trickRepository, FoxRepository foxRepository) {
    this.trickRepository = trickRepository;
    this.foxRepository = foxRepository;
  }

  public ArrayList<String>  findAllTricks() {
    HashMap<String, Integer> trickHashMap = trickRepository.findAll();
    ArrayList<String> tricks = new ArrayList<>();

    for (String trickName : trickHashMap.keySet()) {
      tricks.add(trickName);
    }
    return tricks;
  }

  public ArrayList<String> findTricksNotKnown(String name) {
    Fox fox = foxRepository.findByName(name);
    ArrayList<String> tricksNotKnown = new ArrayList<>();
    ArrayList<String> allTricks = findAllTricks();
    ArrayList<String> tricksAlreadyKnown = fox.getTricks();

    for (String trick : allTricks) {
      if (!tricksAlreadyKnown.contains(trick)) {
        tricksNotKnown.add(trick);
      }
    }
    return tricksNotKnown;
  }

}

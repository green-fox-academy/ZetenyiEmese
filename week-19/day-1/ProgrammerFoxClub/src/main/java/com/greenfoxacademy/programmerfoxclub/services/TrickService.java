package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.repositories.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TrickService {

  private TrickRepository trickRepository;

  @Autowired
  public TrickService(TrickRepository trickRepository) {
    this.trickRepository = trickRepository;
  }

  public ArrayList<String> findAllTricks() {
    return trickRepository.findAll();
  }

  public ArrayList<String> findTricksNotKnown(Fox fox) {
    ArrayList<String> tricksNotKnown = new ArrayList<>();
    ArrayList<String> allTricks = trickRepository.findAll();
    ArrayList<String> tricksAlreadyKnown = fox.getTricks();

    for (String trick : allTricks) {
      if (!tricksAlreadyKnown.contains(trick)) {
        tricksNotKnown.add(trick);
      }
    }
    return tricksNotKnown;
  }

}

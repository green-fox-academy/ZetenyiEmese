package com.greenfoxacademy.programmerfoxclub.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TrickRepository {

  private ArrayList<String> tricks;

  public TrickRepository() {
    this.tricks = new ArrayList<>();
    tricks.add("write HTML");
    tricks.add("code in Java");
    tricks.add("knit pullover");
    tricks.add("make pizza");
    tricks.add("make cheesecake");
    tricks.add("play the guitar");
    tricks.add("climb tree");
    tricks.add("walk backwards");
    tricks.add("dance with you");
    tricks.add("speak English");
  }

  public ArrayList<String> findAll() {
    return tricks;
  }

}

package com.greenfoxacademy.programmerfoxclub.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TrickService {

  private ArrayList<String> tricks;

  public TrickService() {
    tricks = new ArrayList<>();
  }

  public void add(String trick) {
    tricks.add(trick);
  }

  public ArrayList<String> getTricks() {
    return tricks;
  }

  public int countTricks() {
    return tricks.size();
  }

}

package com.greenfoxacademy.hellobeanworld.services;

import org.springframework.stereotype.Service;

@Service
public class GreenColor implements MyColor {

  @Override
  public void printColor() {
    System.out.println("It is green in color...");
  }

}

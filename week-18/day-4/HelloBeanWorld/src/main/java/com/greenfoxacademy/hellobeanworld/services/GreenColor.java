package com.greenfoxacademy.hellobeanworld.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreenColor implements MyColor {

  @Autowired
  private Printer printer;

  @Override
  public void printColor() {
    printer.log("It is green in color...");
    //System.out.println("It is green in color...");
  }

}

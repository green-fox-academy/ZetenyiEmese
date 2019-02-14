package com.greenfoxacademy.hellobeanworld;

import com.greenfoxacademy.hellobeanworld.services.MyColor;
import com.greenfoxacademy.hellobeanworld.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellobeanworldApplication implements CommandLineRunner {

  @Autowired
  private Printer printer;
  @Autowired
  private MyColor myColor;

//  Nem szükséges:
//  @Autowired
//  public HellobeanworldApplication(Printer printer) {
//    this.printer = printer;
//  }

  public static void main(String[] args) {
    SpringApplication.run(HellobeanworldApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    printer.log("Hello Emese!");
    myColor.printColor();
  }

}

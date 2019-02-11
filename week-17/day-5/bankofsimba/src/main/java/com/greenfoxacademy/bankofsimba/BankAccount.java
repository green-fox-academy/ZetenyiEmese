package com.greenfoxacademy.bankofsimba;

public class BankAccount {

  private String name;
  private int balance;
  private String animalType;
  private boolean king;
  private boolean goodGuy;

  public BankAccount(String name, int balance, String animalType, boolean king, boolean goodGuy) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.king = king;
    this.goodGuy = goodGuy;
  }

  public BankAccount(String name, int balance, String animalType) {
    this(name, balance, animalType, true, true);
  }

  public String getName() {
    return name;
  }

  public int getBalance() {
    return balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public boolean isKing() {
    return king;
  }

  public boolean isGoodGuy() {
    return goodGuy;
  }

}

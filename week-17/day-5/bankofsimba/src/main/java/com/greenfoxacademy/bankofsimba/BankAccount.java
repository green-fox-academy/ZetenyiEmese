package com.greenfoxacademy.bankofsimba;

public class BankAccount {

  private String name;
  private int balance;
  private String animalType;
  private boolean king;

  public BankAccount(String name, int balance, String animalType, boolean king) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.king = king;
  }

  public BankAccount(String name, int balance, String animalType) {
    this(name, balance, animalType, true);
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

}

package com.greenfoxacademy.frontendjson.models;

public class Sum {

  private int result;

  public Sum(int until) {
    this.result = sumUpUntil(until);
  }

  private int sumUpUntil(int until){
    int sum = 0;
    for (int i = 1; i <= until; i++) {
      sum += i;
    }
    return sum;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

}

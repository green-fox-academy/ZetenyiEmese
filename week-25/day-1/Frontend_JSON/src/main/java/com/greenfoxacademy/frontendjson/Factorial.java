package com.greenfoxacademy.frontendjson;

public class Factorial {

  private int result;

  public Factorial(int until) {
    this.result = createFactorial(until);
  }

  private int createFactorial(int until){
    int fact = 1;
    for (int i = 1; i <= until; i++) {
      fact *= i;
    }
    return fact;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

}

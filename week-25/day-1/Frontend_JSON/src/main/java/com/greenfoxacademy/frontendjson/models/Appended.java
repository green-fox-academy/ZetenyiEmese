package com.greenfoxacademy.frontendjson.models;

public class Appended {

  private String appended;

  public Appended(String appendable) {
    appended = appendable + "a";
  }

  public String getAppended() {
    return appended;
  }

  public void setAppended(String appended) {
    this.appended = appended;
  }

}

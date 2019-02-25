package com.greenfoxacademy.programmerfoxclub.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ImageRepository {

  private ArrayList<String> images;

  public ImageRepository() {
    this.images = new ArrayList<>();
    images.add("/img/image-fox1.jpg");
    images.add("/img/image-fox2.jpg");
    images.add("/img/image-fox3.jpg");
    images.add("/img/image-fox5.png");
    images.add("/img/image-fox7.jpg");
    images.add("/img/image-fox8.jpg");
  }

  public ArrayList<String> findAll() {
    return images;
  }

}

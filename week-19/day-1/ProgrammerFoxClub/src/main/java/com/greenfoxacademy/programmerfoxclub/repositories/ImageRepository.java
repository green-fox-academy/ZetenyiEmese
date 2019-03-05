package com.greenfoxacademy.programmerfoxclub.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ImageRepository {

  private ArrayList<String> images;

  public ImageRepository() {
    this.images = new ArrayList<>();
    images.add("/img/fox-image1.jpg");
    images.add("/img/fox-image2.jpg");
    images.add("/img/fox-image3.jpg");
    images.add("/img/fox-image4.jpg");
    images.add("/img/fox-image5.png");
    images.add("/img/fox-image6.jpg");
    images.add("/img/fox-image7.jpg");
    images.add("/img/fox-image8.jpg");
  }

  public ArrayList<String> findAll() {
    return images;
  }

}

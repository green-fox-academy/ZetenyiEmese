package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ImageService {

  private ImageRepository imageRepository;

  @Autowired
  public ImageService(ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  public ArrayList<String> findAllImages() {
    return imageRepository.findAll();
  }

}

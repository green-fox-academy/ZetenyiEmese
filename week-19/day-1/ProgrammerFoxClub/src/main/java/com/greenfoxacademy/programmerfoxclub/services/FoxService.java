package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FoxService {

  private FoxRepository foxRepository;

  @Autowired
  public FoxService(FoxRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  public Fox checkLogin(String name) {
    Fox fox = foxRepository.findByName(name);
    if (fox == null){
      fox = new Fox(name);
      foxRepository.save(fox);
    }
    return fox;
  }

}

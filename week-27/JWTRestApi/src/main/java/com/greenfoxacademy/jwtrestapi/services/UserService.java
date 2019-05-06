package com.greenfoxacademy.jwtrestapi.services;

import com.greenfoxacademy.jwtrestapi.models.User;
import com.greenfoxacademy.jwtrestapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean checkUserById(Long id){
    return userRepository.existsById(id);
  }

  public boolean checkUserByName(String usernameToCheck) {
    return userRepository.findUserByUsername(usernameToCheck).isPresent();
  }

  public User findUserByName(String username) {
    return userRepository.findUserByUsername(username).orElse(null);
  }

  public boolean checkUserByNameAndPassword(String usernameToCheck, String passwordToCheck) {
    User user = findUserByName(usernameToCheck);

    if (user != null) {
      String password = user.getPassword();
      return password.equals(passwordToCheck);
    }
    return false;
  }

  public User saveUser(String username, String password) {
    if (!checkUserByName(username)) {
      User newUser = new User(username, password);
      return userRepository.save(newUser);
    }
    return null;
  }

  public ArrayList<User> findAllUsers() {
    ArrayList<User> users = new ArrayList<>();
    userRepository.findAll().forEach(users::add);
    return users;
  }

}

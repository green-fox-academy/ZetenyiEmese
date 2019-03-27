package com.greenfoxacademy.redditapp.services;

import com.greenfoxacademy.redditapp.models.User;
import com.greenfoxacademy.redditapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> findUserById(long id) {
    return userRepository.findById(id);
  }

  public boolean checkUserByName(String usernameToCheck) {
    return userRepository.findUserByUsername(usernameToCheck).isPresent();
  }

  public Optional<User> findUserByName(String username) {
    return userRepository.findUserByUsername(username);
  }

  //long->Long????
  public long findIdForUserWithName(String username) {
    return findUserByName(username).get().getId();
  }

  public boolean checkUserByNameAndPassword(String usernameToCheck, String passwordToCheck) {
    if (checkUserByName(usernameToCheck)) {
      User user = findUserByName(usernameToCheck).get();
      String password = user.getPassword();
      return password.equals(passwordToCheck);
    }
    return false;
  }

  public boolean addUser(String username, String password, String email) {
    if (!checkUserByName(username)) {
      User newUser = new User(username, password, email);
      userRepository.save(newUser);
      return true;
    }
    return false;
  }
}

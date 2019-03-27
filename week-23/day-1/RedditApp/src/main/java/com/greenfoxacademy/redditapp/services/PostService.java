package com.greenfoxacademy.redditapp.services;

import com.greenfoxacademy.redditapp.models.Post;
import com.greenfoxacademy.redditapp.models.User;
import com.greenfoxacademy.redditapp.repositories.PostRepository;
import com.greenfoxacademy.redditapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostService {

  private PostRepository postRepository;
  private UserRepository userRepository;

  @Autowired
  public PostService(PostRepository postRepository, UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  public ArrayList<Post> findAllPosts() {
    ArrayList<Post> posts = new ArrayList<>();
    postRepository.findAll().forEach(posts::add);
    return posts;
  }

  public Optional<Post> findPostById(long postId) {
    return postRepository.findById(postId);
  }

  public ArrayList<Post> findPostsByUser(long userId) {
    return postRepository.findPostsByUser_Id(userId);
  }

  public boolean addPost(String title, String url, long userId) {
    Optional<User> userOptionalInDatabase = userRepository.findById(userId);

    if (userOptionalInDatabase.isPresent()) {
      postRepository.save(new Post(title, url, userOptionalInDatabase.get()));
      return true;
    }
    return false;
  }

}

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

  public ArrayList<Post> findAllPostsInVoteOrder() {
    return postRepository.findAllByOrderByVoteDesc();
  }

  public ArrayList<Post> findPostsByUserInVoteOrder(long userId) {
    return postRepository.findPostsByUser_IdOrderByVoteDesc(userId);
  }

  public Optional<Post> findPostById(long postId) {
    return postRepository.findById(postId);
  }

  public ArrayList<Post> findPostsByUser(long userId) {
    return postRepository.findPostsByUser_Id(userId);
  }

  public int findNumberOfPages() {
    return (findAllPosts().size() - 1) / 10 + 1;
  }

  public ArrayList<Integer> findPageNumberList() {
    int numberOfPages = findNumberOfPages();
    ArrayList<Integer> listOfPageNumbers = new ArrayList<>();

    for (int i = 1; i <= numberOfPages; i++) {
      listOfPageNumbers.add(i);
    }
    return listOfPageNumbers;
  }

  public ArrayList<Post> findPostsForPage(int pageNumber) {
    ArrayList<Post> posts = new ArrayList<>();
    int numberOfPosts = findAllPosts().size();
    int maxPageNumber = findNumberOfPages();

    if (pageNumber < 1) {
      pageNumber = 1;
    }
    if (pageNumber > maxPageNumber) {
      pageNumber = maxPageNumber;
    }

    int from = (pageNumber - 1) * 10 + 1; //minimum = 1
    int til = (pageNumber - 1) * 10 + 10;

    for (int i = from; i <= numberOfPosts && i <= til; i++) {
      posts.add(findAllPostsInVoteOrder().get(i - 1));
    }
    return posts;
  }

  public boolean addPost(String title, String url, long userId) {
    if (isUserInDatabase(userId)) {
      postRepository.save(new Post(title, url, userRepository.findById(userId).get()));
      return true;
    }
    return false;
  }

  public void deletePost(long userId, long postId) {
    if (isUserInDatabase(userId) && isPostInDatabase(postId)) {
      User userInDB = userRepository.findById(userId).get();
      Post postInDB = postRepository.findById(postId).get();

      if (isUserOwnerOfPost(userInDB, postInDB)) {
        postRepository.deleteById(postId);
      }
    }
  }

  public void votePost(long userId, long postId, String direction) {
    if (isUserInDatabase(userId) && isPostInDatabase(postId)) {
      User userInDB = userRepository.findById(userId).get();
      Post postInDB = postRepository.findById(postId).get();

      if (isPostVoteableByUser(userInDB, postInDB)) {
        if (direction.equals("up")) {
          postInDB.setVote(postInDB.getVote() + 1);
        } else if (direction.equals("down")) {
          postInDB.setVote(postInDB.getVote() - 1);
        }

        postInDB.getVoters().add(userInDB);
        postRepository.save(postInDB);
      }
    }
  }

  private boolean isPostVoteableByUser(User user, Post post) {
    return !isUserOwnerOfPost(user, post) && !isUserVoterOfPost(user, post);
  }

  private boolean isUserOwnerOfPost(User user, Post post) {
    return post.getUser().equals(user);
  }

  private boolean isUserVoterOfPost(User user, Post post) {
    return postRepository.findPostsByVotersIs(user).contains(post);
  }

  private boolean isUserInDatabase(long userId) {
    return userRepository.existsById(userId);
  }

  private boolean isPostInDatabase(long postId) {
    return postRepository.existsById(postId);
  }

}

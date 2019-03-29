package com.greenfoxacademy.redditapp.repositories;

import com.greenfoxacademy.redditapp.models.Post;
import com.greenfoxacademy.redditapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
  public ArrayList<Post> findPostsByUser_Id(long userId);
  public ArrayList<Post> findAllByOrderByVoteDesc();
  public ArrayList<Post> findPostsByUser_IdOrderByVoteDesc(long userId);
  public ArrayList<Post> findPostsByVotersIs(User user);
}

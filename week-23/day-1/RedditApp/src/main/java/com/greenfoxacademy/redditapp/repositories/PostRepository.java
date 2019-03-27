package com.greenfoxacademy.redditapp.repositories;

import com.greenfoxacademy.redditapp.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
  public ArrayList<Post> findPostsByUser_Id(long userId);
}

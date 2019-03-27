package com.greenfoxacademy.redditapp.controllers;

import com.greenfoxacademy.redditapp.models.User;
import com.greenfoxacademy.redditapp.services.PostService;
import com.greenfoxacademy.redditapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PostController {

  private PostService postService;
  private UserService userService;

  @Autowired
  public PostController(PostService postService, UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @GetMapping("")
  public String start(Model model) {
    model.addAttribute("posts", postService.findAllPosts());
    model.addAttribute("allPosts", true);
    return "post_list";
  }

  @GetMapping("/{userId}/{allPosts}")
  public String showPosts(@PathVariable long userId, @PathVariable Boolean allPosts, Model model) {
    Optional<User> userOptionalInDatabase = userService.findUserById(userId);

    if (userOptionalInDatabase.isPresent()) {
      model.addAttribute("user", userOptionalInDatabase.get());

      if (allPosts) {
        model.addAttribute("posts", postService.findAllPosts());
        model.addAttribute("allPosts", true);
      } else {
        model.addAttribute("posts", postService.findPostsByUser(userId));
        model.addAttribute("allPosts", false);
      }

    } else {
      model.addAttribute("error", "No user found!");
    }
    return "post_list";
  }

  @GetMapping("/{userId}/submit")
  public String submitNewPost(@PathVariable long userId, Model model) {
    Optional<User> userOptionalInDatabase = userService.findUserById(userId);

    if (userOptionalInDatabase.isPresent()) {
      model.addAttribute("user", userOptionalInDatabase.get());
    }
    return "submit_post";
  }

  @PostMapping("/{userId}/submit")
  public String submitNewPost(@PathVariable long userId, @ModelAttribute(value = "title") String title,
                                                         @ModelAttribute(value = "url") String url) {
    postService.addPost(title, url, userId);
    return "redirect:/" + userId + "/false";
  }


}

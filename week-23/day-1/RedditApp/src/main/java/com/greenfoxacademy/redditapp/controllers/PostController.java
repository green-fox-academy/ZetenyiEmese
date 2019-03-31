package com.greenfoxacademy.redditapp.controllers;

import com.greenfoxacademy.redditapp.models.User;
import com.greenfoxacademy.redditapp.services.PostService;
import com.greenfoxacademy.redditapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
  public String start(@RequestParam(required = false) Integer page, Model model) {
//    model.addAttribute("posts", postService.findAllPosts());
//    model.addAttribute("posts", postService.findAllPostsInVoteOrder());
    if (page == null) {
      model.addAttribute("posts", postService.findPostsForPage(1));
    } else {
      model.addAttribute("posts", postService.findPostsForPage(page));
    }
    model.addAttribute("pageNumbers", postService.findPageNumberList());
    return "start_page";
  }

  @GetMapping("/{userId}")
  public String showPosts(@PathVariable long userId, @RequestParam boolean allPosts, Model model) {
    findUserAndAddToModel(userId, model);

    if (allPosts) {
//        model.addAttribute("posts", postService.findAllPosts());
      model.addAttribute("posts", postService.findAllPostsInVoteOrder());
      model.addAttribute("allPosts", true);
    } else {
//        model.addAttribute("posts", postService.findPostsByUser(userId));
      model.addAttribute("posts", postService.findPostsByUserInVoteOrder(userId));
      model.addAttribute("allPosts", false);
    }
    return "post_list";
  }

  @GetMapping("/{userId}/submit")
  public String submitNewPost(@PathVariable long userId, Model model) {
    findUserAndAddToModel(userId, model);
    return "submit_post";
  }

  @PostMapping("/{userId}/submit")
  public String submitNewPost(@PathVariable long userId,
                              @ModelAttribute(value = "title") String title,
                              @ModelAttribute(value = "url") String url) {
    postService.addPost(title, url, userId);
    return "redirect:/" + userId + "?allPosts=false";
  }

  @PostMapping("/{userId}/delete/{postId}")
  public String deletePost(@PathVariable long userId, @PathVariable long postId) {
    postService.deletePost(userId, postId);
    return "redirect:/" + userId + "?allPosts=false";
  }

  @PostMapping("/{userId}/upvote/{postId}")
  public String upvotePost(@PathVariable long userId, @PathVariable long postId) {
    postService.votePost(userId, postId, "up");
    return "redirect:/" + userId + "?allPosts=true";
  }

  @PostMapping("/{userId}/downvote/{postId}")
  public String downvotePost(@PathVariable long userId, @PathVariable long postId) {
    postService.votePost(userId, postId, "down");
    return "redirect:/" + userId + "?allPosts=true";
  }

  private void findUserAndAddToModel(long userId, Model model) {
    Optional<User> userOptionalInDatabase = userService.findUserById(userId);

    if (userOptionalInDatabase.isPresent()) {
      model.addAttribute("user", userOptionalInDatabase.get());
    } else {
      model.addAttribute("error", "No user found!");
    }
  }

}

package com.fraido.cyprusbeer.controller;

import com.fraido.cyprusbeer.entity.Post;
import com.fraido.cyprusbeer.entity.User;
import com.fraido.cyprusbeer.repositories.UsersRepository;
import com.fraido.cyprusbeer.requests.PostRequest;
import com.fraido.cyprusbeer.services.PostsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {

   @Autowired
   private PostsService postsService;

   @Autowired
   private UsersRepository usersRepository;

   @Autowired
   private Post newPost;

   @GetMapping("/posts")
   @Operation(summary = "get all posts")
   public ResponseEntity getAllPosts() {
      List<Post> posts = postsService.findAll();
      ResponseEntity body = ResponseEntity.ok().body(posts);
      return body;
   }

   @GetMapping("/post/{id}")
   @Operation(summary = "get post by id")
   public ResponseEntity getPostById(@PathVariable int id) {
      ResponseEntity body;
      try {
         Post entity = postsService.findById(id);
         body = ResponseEntity.ok().body(entity);
      } catch (Exception e) {
         body = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Страница не найдена");
      }
      return body;
   }

   @DeleteMapping("/post/{id}")
   @Operation(summary = "delete post by id")
   public ResponseEntity deletePostById(@PathVariable int id) {
      ResponseEntity body;
      try {
         postsService.delete(id);
         body = ResponseEntity.status(HttpStatus.OK).body("ok");
      } catch (Exception e) {
         body = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Page not found");
      }
      return body;
   }

   @PostMapping("/post")
   @Operation(summary = "create new post")
   @Autowired
   public Post save(@RequestBody PostRequest post) {
      try {
         newPost.setTitle(post.getTitle());
         newPost.setDescription(post.getDescription());
         int userId = post.getUserId();
         User user = usersRepository.findById(userId).orElse(null);
         newPost.setUser(user);
         postsService.save(newPost);
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return newPost;
   }

   @GetMapping("/posts/{title}")
   @Operation(summary = "get all posts by title")
   public ResponseEntity getAllPostsByTitle(@PathVariable String title) {
      ResponseEntity body;
      try {
         List<Post> entity = postsService.findByTitle(title);
         body = ResponseEntity.ok().body(entity);
      } catch (Exception e) {
         body = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Страница не найдена");
      }
      return body;
   }

   @GetMapping("/posts/user/{user}")
   @Operation(summary = "get all posts by user")
   public ResponseEntity getAllPostsByUser(@PathVariable String user) {
      ResponseEntity body;
      try {
         User foundUser = usersRepository.findByUserName(user);
         List<Post> entity = postsService.findByUser(foundUser);
         body = ResponseEntity.ok().body(entity);
      } catch (Exception e) {
         body = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Страница не найдена");
      }
      return body;
   }
}

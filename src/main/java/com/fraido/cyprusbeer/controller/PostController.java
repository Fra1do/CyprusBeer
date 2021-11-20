package com.fraido.cyprusbeer.controller;

import com.fraido.cyprusbeer.dto.PostDto;
import com.fraido.cyprusbeer.entity.Post;
import com.fraido.cyprusbeer.entity.User;
import com.fraido.cyprusbeer.repositories.UsersRepository;
import com.fraido.cyprusbeer.services.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {

   @Autowired
   private IPostsService postsService;

   @Autowired
   private UsersRepository usersRepository;

   @GetMapping("/posts")
   public ResponseEntity getAllPosts() {
      List<Post> posts = postsService.findAll();
      ResponseEntity body = ResponseEntity.ok().body(posts);
      return body;
   }

   @GetMapping("/post/{id}")
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
   public ResponseEntity deletePostById(@PathVariable int id) {
      ResponseEntity body;
      try {
         postsService.deleteByIdIs(id);
         body = ResponseEntity.status(HttpStatus.OK).body("ok");
      } catch (Exception e) {
         body = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Page not found");
      }
      return body;
   }

   @PostMapping("/post")
   public ResponseEntity save(@RequestBody PostDto post) {
      ResponseEntity body;
      try {
         Post newPost = new Post();
         newPost.setTitle(newPost.getTitle());
         newPost.setDescription(newPost.getDescription());
         int userId = post.getUserId();
         User user = usersRepository.findById(userId).get();
         newPost.setUser(user);
         postsService.save(newPost);
         return (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED);
      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Page not found");
      }
   }
}

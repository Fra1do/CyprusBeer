package com.fraido.cyprusbeer.controller;

import com.fraido.cyprusbeer.dto.PostDto;
import com.fraido.cyprusbeer.entity.PostEntity;
import com.fraido.cyprusbeer.entity.UserEntity;
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
      List<PostEntity> posts = postsService.findAll();
      ResponseEntity body = ResponseEntity.ok().body(posts);
      return body;
   }

   @GetMapping("/posts/{id}")
   public ResponseEntity getPostById(@PathVariable int id) {
      ResponseEntity body;
      try {
         PostEntity entity = postsService.findById(id);
         body = ResponseEntity.ok().body(entity);
      } catch (Exception e) {
         body = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Страница не найдена");
      }
      return body;
   }

   @DeleteMapping("/posts/{id}")
   public ResponseEntity deletePostById(@PathVariable int id) {
      ResponseEntity body;
      try {
         PostEntity entity = postsService.findById(id);
         postsService.deleteByIdIs(id);
         body = ResponseEntity.status(HttpStatus.OK).body("ok");
      } catch (Exception e) {
         body = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Страница не найдена");
      }
      return body;
   }

   @PostMapping("/posts")
   public PostEntity save(@RequestBody PostDto post) {
      PostEntity myEntity = new PostEntity();
      myEntity.setTitle(post.getTitle());
      myEntity.setDescription(post.getDescription());
      int userId = post.getUserId();
      UserEntity user = usersRepository.findById(userId).get();
      myEntity.setUserEntity(user);
      return this.postsService.save(myEntity);
   }
}

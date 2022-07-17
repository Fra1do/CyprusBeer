package com.fraido.cyprusbeer.controller;

import com.fraido.cyprusbeer.entity.User;
import com.fraido.cyprusbeer.requests.UserRequest;
import com.fraido.cyprusbeer.services.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UsersService usersRepository;

    @Autowired
    private User newUser;

    @GetMapping("/users")
    @Operation(summary = "get all users")
    public ResponseEntity getAllUsers() {
        List<User> users = usersRepository.findAll();
        ResponseEntity body = ResponseEntity.ok().body(users);
        return body;
    }

    @PostMapping("/user")
    @Operation(summary = "add new user")
    public User save(@RequestBody UserRequest userRequest) {
        try {
            newUser.setUserName(userRequest.getUsername());
            usersRepository.save(newUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return newUser;
    }

    @PutMapping("/user/{id}")
    @Operation(summary = "edit user")
    public User edit(@RequestBody UserRequest userRequest, @PathVariable int id) {
        User user = null;
        try {
           user = usersRepository.findById(id);
           user.setUserName(userRequest.getUsername());
            usersRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @GetMapping("/users/{username}")
    @Operation(summary = "get all users by username")
    public ResponseEntity getAllUsersByUsername(String username) {
        User users = usersRepository.getUsersByUserName(username);
        ResponseEntity body = ResponseEntity.ok().body(users);
        return body;
    }
}

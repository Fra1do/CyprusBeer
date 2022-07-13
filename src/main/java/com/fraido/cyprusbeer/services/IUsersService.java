package com.fraido.cyprusbeer.services;

import com.fraido.cyprusbeer.entity.User;

import java.util.List;

public interface IUsersService {
    List<User> findAll();
    User findById(int id);
    User save(User user);
}

package com.fraido.cyprusbeer.services;

import com.fraido.cyprusbeer.entity.UserEntity;

import java.util.List;

public interface IUsersService {
    List<UserEntity> findAll();
    UserEntity findById(int id);
}

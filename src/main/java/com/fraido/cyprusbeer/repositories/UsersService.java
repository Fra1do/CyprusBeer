package com.fraido.cyprusbeer.repositories;

import com.fraido.cyprusbeer.entity.UserEntity;
import com.fraido.cyprusbeer.services.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private UsersRepository repository;

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.addAll(repository.findAll());

        return userEntities;
    }

    @Override
    public UserEntity findById(int id) {
        return findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();
    }


}


package com.fraido.cyprusbeer.repositories;

import com.fraido.cyprusbeer.entity.User;
import com.fraido.cyprusbeer.requests.UserRequest;
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
    public List<User> findAll() {
        List<User> userEntities = new ArrayList<>();
        userEntities.addAll(repository.findAll());

        return userEntities;
    }

    @Override
    public User findById(int id) {
        return findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public User save(User user) {
        repository.save(user);
        return user;
    }


}


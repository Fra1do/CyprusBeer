package com.fraido.cyprusbeer.services;

import com.fraido.cyprusbeer.entity.User;
import com.fraido.cyprusbeer.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersService {

    private final UsersRepository repository;

    @Autowired
    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        List<User> userEntities = new ArrayList<>();
        userEntities.addAll(repository.findAll());

        return userEntities;
    }

    public User findById(int id) {
        Optional<User> foundPost = repository.findById(id);
        return foundPost.orElse(null);
    }

    @Transactional
    public User save(User user) {
        repository.save(user);
        return user;
    }

    public User getUsersByUserName(String username) {
        return repository.findByUserName(username);
    }

}


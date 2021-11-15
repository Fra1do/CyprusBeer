package com.fraido.cyprusbeer.repositories;

import com.fraido.cyprusbeer.entity.PostEntity;
import com.fraido.cyprusbeer.services.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsService implements IPostsService {

    @Autowired
    private PostsRepository repository;

     public List<PostEntity> findAll() {
        List<PostEntity> postEntities = new ArrayList<>();
        postEntities.addAll(repository.findAll());

        return postEntities;
    }

    @Override
    public PostEntity findById(int id) {
        return findAll().stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .get();
    }

    @Override
    public PostEntity save(PostEntity postEntity) {
        repository.save(postEntity);
        return postEntity;
    }

    @Override
    public void deleteByIdIs(int id) {
        repository.delete(findById(id));
    }

    @Override
    public void deleteByIdIs(PostEntity entity) {

    }

}

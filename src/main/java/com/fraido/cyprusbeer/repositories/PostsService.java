package com.fraido.cyprusbeer.repositories;

import com.fraido.cyprusbeer.entity.Post;
import com.fraido.cyprusbeer.services.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsService implements IPostsService {

    @Autowired
    private PostsRepository repository;

     public List<Post> findAll() {
        List<Post> postEntities = new ArrayList<>();
        postEntities.addAll(repository.findAll());

        return postEntities;
    }

    @Override
    public Post findById(int id) {
        return findAll().stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .get();
    }

    @Override
    public Post save(Post post) {
        repository.save(post);
        return post;
    }

    @Override
    public void deleteByIdIs(int id) {
        repository.delete(findById(id));
    }
}

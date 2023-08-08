package com.fraido.cyprusbeer.services;

import com.fraido.cyprusbeer.entity.Post;
import com.fraido.cyprusbeer.entity.User;
import com.fraido.cyprusbeer.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PostsService {

    private final PostsRepository repository;

    @Autowired
    public PostsService(PostsRepository repository) {
        this.repository = repository;
    }

     public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(int id) {
        Optional<Post> foundPost = repository.findById(id);
        return foundPost.orElse(null);
    }

    @Transactional
    public void save(Post post) {
        repository.save(post);
    }

    @Transactional
    public void update(int id, Post updatedPost) {
        updatedPost.setId(id);
        updatedPost.setTitle(updatedPost.getTitle());
        updatedPost.setDescription(updatedPost.getDescription());
        repository.save(updatedPost);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Post> findByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    public List<Post> findByUser(User user) {
        return repository.findByUser(user);
    }

    @Transactional
    public void deletePostsByTitle(String title) {
        List<Post> posts = findByTitle(title);
        for (Post p : posts
             ) {
            System.out.println(p.getId());
            delete(p.getId());
        }
    }
}

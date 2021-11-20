package com.fraido.cyprusbeer.services;
import com.fraido.cyprusbeer.entity.Post;
import java.util.List;

public interface IPostsService {
    List<Post> findAll();
    Post findById(int id);
    Post save(Post post);
    void deleteByIdIs(int id);

    void deleteByIdIs(Post entity);
}

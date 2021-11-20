package com.fraido.cyprusbeer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fraido.cyprusbeer.entity.Post;
import java.util.List;

@Repository
public interface PostsRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();

    Post save(Post post);

//    PostEntity deleteByIdIs(int id);
}

package com.fraido.cyprusbeer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fraido.cyprusbeer.entity.PostEntity;
import java.util.List;

@Repository
public interface PostsRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAll();

    PostEntity save(PostEntity postEntity);

//    PostEntity deleteByIdIs(int id);
}

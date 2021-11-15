package com.fraido.cyprusbeer.services;
import com.fraido.cyprusbeer.entity.PostEntity;
import java.util.List;

public interface IPostsService {
    List<PostEntity> findAll();
    PostEntity findById(int id);
    PostEntity save(PostEntity postEntity);
    void deleteByIdIs(int id);

    void deleteByIdIs(PostEntity entity);
}

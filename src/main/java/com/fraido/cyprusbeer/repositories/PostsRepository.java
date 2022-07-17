package com.fraido.cyprusbeer.repositories;

import com.fraido.cyprusbeer.entity.Post;
import com.fraido.cyprusbeer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Post, Integer> {
    List<Post> findByTitleContainingIgnoreCase(String title);

    List<Post> findByUser(User user);
}

package com.fraido.cyprusbeer.repositories;

import com.fraido.cyprusbeer.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findAll();
}

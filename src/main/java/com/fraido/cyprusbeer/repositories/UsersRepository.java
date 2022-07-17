package com.fraido.cyprusbeer.repositories;

import com.fraido.cyprusbeer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);


}

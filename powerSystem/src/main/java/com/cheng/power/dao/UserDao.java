package com.cheng.power.dao;

import com.cheng.power.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * 周刘成   2020-1-8
 */
public interface UserDao extends CrudRepository<User, Long> {

    @Query("select u from User u where u.username=:username")
    User findUserByName(@Param("username") String username);

    User findUserByUsername(String username);

}

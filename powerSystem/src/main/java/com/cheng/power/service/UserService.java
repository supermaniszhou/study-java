package com.cheng.power.service;

import com.cheng.power.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * 周刘成   2020-1-8
 */
public interface UserService {

    void saveUser(User user);

    void deleteUser(Long id);

    Optional<User> findUserByid(Long id);

    Iterable<User> findAll();
}

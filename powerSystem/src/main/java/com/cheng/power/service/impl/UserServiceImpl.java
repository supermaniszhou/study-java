package com.cheng.power.service.impl;

import com.cheng.power.dao.UserDao;
import com.cheng.power.entity.User;
import com.cheng.power.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 周刘成   2020-1-8
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = false)
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserByid(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<User> findAll() {
        return userDao.findAll();
    }
}

package com.zhou.dao;

import com.zhou.po.User;

/**
 * 周刘成   2019-12-5
 */
public interface UserDao {
    User findUserByUsernamePwd(String... params);
}

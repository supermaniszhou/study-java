package com.zhou.service;

import com.zhou.dao.UserDao;
import com.zhou.dao.UserDaoImpl;
import com.zhou.po.User;

/**
 * 周刘成   2019-12-5
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User findUser(String... params) {
        return dao.findUserByUsernamePwd(params[0], params[1]);
    }
}

package cn.cheng.sbsm.service.impl;

import cn.cheng.sbsm.mapper.UserMapper;
import cn.cheng.sbsm.pojo.User;
import cn.cheng.sbsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 周刘成   2020-1-14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}

package cn.cheng.sbsm.service.impl;

import cn.cheng.sbsm.mapper.UserMapper;
import cn.cheng.sbsm.pojo.User;
import cn.cheng.sbsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 周刘成   2020-1-14
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insertUser(User user) {
        userMapper.insertUser(user);
//        int i = 1 / 0;
    }

    @Override
//    使用缓存
    @Cacheable(value = "users")
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteUserById(int id) {
        userMapper.deleteUserById(id);
    }
}

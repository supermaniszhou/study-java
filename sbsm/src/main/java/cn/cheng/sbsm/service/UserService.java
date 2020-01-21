package cn.cheng.sbsm.service;

import cn.cheng.sbsm.pojo.User;

import java.util.List;

/**
 * 周刘成   2020-1-14
 */
public interface UserService {
    void insertUser(User user);

    List<User> selectAllUser();

    User selectUserById(User user);

    User updateUser(User user);

    void deleteUserById(int id);
}

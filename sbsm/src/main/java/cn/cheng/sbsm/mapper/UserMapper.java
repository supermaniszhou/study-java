package cn.cheng.sbsm.mapper;

import cn.cheng.sbsm.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 周刘成   2020-1-14
 */
@Repository
public interface UserMapper {
    void insertUser(User user);

    List<User> selectAllUser();

    User selectUserById(int id);

    void updateUser(User user);

    void deleteUserById(int id);
}

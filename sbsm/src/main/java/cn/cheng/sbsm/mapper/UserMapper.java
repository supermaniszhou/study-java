package cn.cheng.sbsm.mapper;

import cn.cheng.sbsm.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * 周刘成   2020-1-14
 */
@Repository
public interface UserMapper {
    void insertUser(User user);
}

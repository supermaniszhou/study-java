package cn.cheng.sbsm.jpa;

import cn.cheng.sbsm.pojo.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * 周刘成   2020-1-17
 */
public interface UserRepositoryBy extends Repository<User, Integer> {
    List<User> findByUsername(String username);

//    List<User> findByNameAndAge(String name, String password);

    List<User> findByUsernameLike(String username);
}

package cn.cheng.sbsm.jpa;

import cn.cheng.sbsm.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 周刘成   2020-1-17
 */
public interface UserRepository  extends JpaRepository<User,Integer> {
}

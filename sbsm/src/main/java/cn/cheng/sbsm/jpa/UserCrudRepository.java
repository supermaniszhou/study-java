package cn.cheng.sbsm.jpa;

import cn.cheng.sbsm.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 周刘成   2020-1-17
 */
public interface UserCrudRepository extends CrudRepository<User,Integer> {
}

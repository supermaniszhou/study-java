package cn.cheng.sbsm.jpa;

import cn.cheng.sbsm.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 周刘成   2020-1-17
 */
public interface UserRepositoryQuery extends Repository<User, Integer> {

    @Query("from User where username=?1")
    List<User> queryByUsernameHql(String name);

    @Query(value = "select * from sys_user where username= ?1", nativeQuery = true)
    List<User> queryByUsernameSql(String name);

    @Query("update User set username= ?1 where id = ?2")
    @Modifying
//    因为使用SpringDataJPA 做增删改的时候,是需要有事务参与的。忘记加事务就会报这种错误。
    @Transactional
    void updateUserByID(String username, int id);
}

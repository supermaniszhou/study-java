package com.zhou.dao;

import com.zhou.po.User;
import com.zhou.util.BeanFactoryUtil;
import com.zhou.util.JdbcUtil;
import com.zhou.util.TransationManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * 周刘成   2019-12-5
 */
public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

    @Override
    public User findUserByUsernamePwd(String... params) {
        User user = null;
        try {
            String sql = "select * from users where username=? and password=?";
            user = queryRunner.query(TransationManager.getConnection(), sql, new BeanHandler<>(User.class), params[0], params[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

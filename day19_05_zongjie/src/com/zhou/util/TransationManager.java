package com.zhou.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 周刘成   2019-12-5
 */
public class TransationManager {
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    public static Connection getConnection() {
        Connection connection = tl.get();
        if (connection == null || connection.equals("NULL") || "".equals(connection)) {
            connection = JdbcUtil.getCon();
            tl.set(connection);
        }
        return connection;
    }

    public static void startTransation() {
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commitTransation() {
        Connection connection = getConnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback() {
        Connection connection = getConnection();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        Connection connection = getConnection();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

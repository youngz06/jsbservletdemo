package com.zyoungBlog.conn;

import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

/**
 * Created by youngz on 16-8-18.
 */
public class ConnectionUtils {
    public static Connection getConnection()
        throws ClassNotFoundException,SQLException {
        //Here use mysql database;

        return MySQLConnUtils.getMySQLConnection();
    }

    public static void closeQuietly(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {

        }
    }

    public static void rollbackQuietly(Connection connection) {
        try {
            connection.rollback();
        } catch (Exception e) {

        }
    }

}

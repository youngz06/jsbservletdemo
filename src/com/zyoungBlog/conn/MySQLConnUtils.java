package com.zyoungBlog.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by youngz on 16-8-18.
 */
public class MySQLConnUtils {
    public static Connection getMySQLConnection() throws ClassNotFoundException,SQLException {
        //Change the connection parameters accordingly.
        String hostName = "localhost";
        String dbName = "demo";
        String userName = "root";
        String password = "yz9406";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException,
            ClassNotFoundException {
        //Declar the class Driver for MySQL DB;
        //This is necessary with Java (older)
        //Java6(or newer) automatically find the appropriate driver.
        //If you use java>5,the this line is not needed;
//        Class.forName("com.mysql.jdbc.Driver");
        //URL Connection for MySql
        //Example:jdb:mysql://localhost:3306/simlehr
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}

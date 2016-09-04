package com.zyoungBlog.utils;

import com.zyoungBlog.beans.Product;
import com.zyoungBlog.beans.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngz on 16-8-22.
 */
public class DBUtils {
    public static UserAccount findUser(Connection connection,String userName,String password)throws SQLException {
        String sql = "Select User_Name,Password,Gender from USER_ACCOUNT " + " where User_Name = ? and password = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPasswd(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }
    public static UserAccount findUser(Connection conn,String userName)throws  SQLException {

        String sql = "Select USER_NAME,PASSWORd,GENDER from USER_ACCOUNT" + " where User_Name = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String password = rs.getString("Password");
            String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPasswd(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }
    public static List<Product> querProduct(Connection conn) throws  SQLException {
        String sql = "Select Code,Name,Price from PRODUCT ";
        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<>();
        while (rs.next()) {
            String code = rs.getString("CODE");
            String name = rs.getString("NAME");
            float price = rs.getFloat("PRICE");
            Product product = new Product(code,name,price);
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            list.add(product);
        }
        return list;
    }

    public static Product findProduct(Connection conn,String code) throws SQLException {
        String sql = "Select Code, Name, Price from PRODUCT  where Code=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String name = rs.getString("Name");
            float price = rs.getFloat("Price");
            Product product = new Product(code, name, price);
            return product;
        }
        return null;
    }

    public static void updateProduct(Connection conn,Product product) throws  SQLException {
        String sql = "Update PRODUCT set Name=?, Price=? where Code=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setString(3, product.getCode());
        pstm.executeLargeUpdate();
    }

    public static void insertProduct(Connection conn,Product product) throws SQLException {
        String sql = "Insert into PRODUCT(Code,Name,Price) values (?,?,?))";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, product.getCode());
        pstm.setString(2, product.getName());
        pstm.setFloat(3, product.getPrice());

        pstm.executeLargeUpdate();
    }

    public static void deleteProduct(Connection conn,String code) throws SQLException {
        String sql = "Delete PRODUCT where Code= ?";
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1,code);
        pstm.executeLargeUpdate();
    }



}


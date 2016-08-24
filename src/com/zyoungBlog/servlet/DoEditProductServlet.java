package com.zyoungBlog.servlet;

import com.zyoungBlog.beans.Product;
import com.zyoungBlog.conn.MySQLConnUtils;
import com.zyoungBlog.utils.DBUtils;
import com.zyoungBlog.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by youngz on 16-8-24.
 */
@WebServlet(name = "DoEditProductServlet", urlPatterns = "/doEditProduct")
public class DoEditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DoEditProductServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);

        String code = (String) request.getParameter("code");
        String name = (String) request.getParameter("name");
        String priceStr = (String) request.getParameter("price");
        float price = 0;
        try {
            price = Float.parseFloat(priceStr);
        } catch (Exception e) {

        }
        Product product = new Product(code, name, price);

        String errorString = null;

        try {
            DBUtils.updateProduct(conn, product);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        //Store infomatino to request attribute,before forward to views

        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);

        //If error,forward to Edit page
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
            dispatcher.forward(request, response);
        }
        //if everything nice
        //Redirect to the product listing page
        else {
            response.sendRedirect(request.getContextPath()+"/productList");
        }
    }
}

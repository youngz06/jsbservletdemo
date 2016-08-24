package com.zyoungBlog.servlet;

import com.zyoungBlog.beans.Product;
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
import java.util.List;

/**
 * Created by youngz on 16-8-24.
 */
@WebServlet(name = "ProductListServlet", urlPatterns = {"/productList"})
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ProductListServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);

        String errorString = null;
        List<Product> list = null;
        try {
            list = DBUtils.querProduct(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        //Store info in request attribute,before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);

        //Forward to /WEB-INF/views/productListview.jsp
        RequestDispatcher dispatcher
                = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/productListView.jsp");
        dispatcher.forward(request, response);
    }
}

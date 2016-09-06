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

/**
 * Created by youngz on 16-8-24.
 */
@WebServlet(name = "EditProductServlet",urlPatterns = "/editProduct")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditProductServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);

        String code = (String) request.getParameter("code");
        Product product = null;
        String errorString = null;

        try {
            product = DBUtils.findProduct(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        //if no error.
        //the product does not exist to edit.
        //Redirect to productList page.
        if (errorString != null && product == null) {
            response.sendRedirect(request.getServletPath() + "/producList");
            return;
        }
        //Store errorString in request attrbute,before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(
                "/WEB-INF/views/editProductView.jsp");
        dispatcher.forward(request, response);
    }
}

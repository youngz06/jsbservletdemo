package com.zyoungBlog.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by youngz on 16-8-24.
 */
@WebServlet(name = "CreateProductServlet", urlPatterns = {"/createProduct"})
public class CreateProductServlet extends HttpServlet {
    private static long serialVersionUID = 1L;

    public CreateProductServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(
                "/WEB-INF/views/createProductView.jsp");
        dispatcher.forward(request, response);
    }
}

package com.zyoungBlog.servlet;

import com.zyoungBlog.beans.UserAccount;
import com.zyoungBlog.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by youngz on 16-8-24.
 */
@WebServlet(name = "UserInfo")
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserInfoServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();

        //Check User has logged on
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        //Not logged in

        if (loginedUser == null) {
            //redirect to login page
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        //Store info in request attribute
        request.setAttribute("user", loginedUser);

        //Logined,forward to /WEB-INF/views/userInfoView.jsp
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
        dispatcher.forward(request, response);
    }

}

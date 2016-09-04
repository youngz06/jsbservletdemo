package com.zyoungBlog.servlet;

import com.zyoungBlog.beans.UserAccount;
import com.zyoungBlog.utils.DBUtils;
import com.zyoungBlog.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.DataBufferUShort;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by youngz on 16-8-24.
 */
@WebServlet(urlPatterns = {"/doLogin"})
public class DoLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DoLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String rememberMeStr = req.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);

        UserAccount user = null;
        boolean hasError = false;
        String errorString = null;

        if (userName == null || password == null
                || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password !";
        } else {
            Connection conn = MyUtils.getStoredConnection(req);
            try {
                user = DBUtils.findUser(conn, userName, password);

                if (user == null) {
                    hasError = true;
                    errorString = "User Name or password invalid";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        //if error,forward to /WEB-INF/views/login.jsp
        if (hasError) {
            user = new UserAccount();
            user.setUserName(userName);
            user.setPasswd(password);

            //Store information in request attribute,before forward
            req.setAttribute("errorString", errorString);
            req.setAttribute("user", user);

            //Forwar to /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(req, resp);
        }
        //if no error
        //Store user information in session
        //and redirect to userInfo page;
        else{
            HttpSession session = req.getSession();
            MyUtils.storeLoginedUser(session, user);
            //if user checked "Remember me"
            if (remember) {
                MyUtils.storeUserCookie(resp, user);
            }
            //Else delete cookie
            else {
                MyUtils.deleteUserCookie(resp);
            }
            //Redirect to userInfo page.
            resp.sendRedirect(req.getContextPath() + "/userInfo");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

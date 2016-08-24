package com.zyoungBlog.filter;

import com.zyoungBlog.conn.ConnectionUtils;
import com.zyoungBlog.utils.MyUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by youngz on 16-8-24.
 */
@WebFilter(filterName = "jdbcFilter", urlPatterns = {"/*"})
public class JDBCFilter implements Filter {

    public JDBCFilter() {
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }/*
    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }*/

    private boolean needJDBC(HttpServletRequest request) {
        //
        //Servlet Url-pattern:/spath/*
        //
        // =>/spath
        String servletPath = request.getServletPath();
        // =>abc/mnp
        String pathInfo = request.getPathInfo();

        String urlPattern = servletPath;
        if (pathInfo != null) {
            // =>/spath/*
            urlPattern = servletPath + "/*";
        }
        //key:servletName.
        //Value:ServletRegistration
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();

        //Collection of all servlet in your webapp.
        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

//    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        //
        //Only open connectionos for the special requests need
        //connection.(For example, the path to the servlet ,JSP,...
        //
        //Avoid open connection for commons request
        //(for example:imgae,css,javascript,....)
        //
        if (this.needJDBC(req)) {
            System.out.println("Open Connection for: " + req.getServletPath());

            Connection conn = null;
            try {
                //Create connection
                conn = ConnectionUtils.getConnection();
                //Set Auto commit to false;
                conn.setAutoCommit(false);
                //Store connectin in atrribute of request
                MyUtils.storeConnection(request, conn);
                //Allow request to go forward
                //(Go to the next filter or target)
                chain.doFilter(request, response);

                //Commit change
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
                ConnectionUtils.rollbackQuietly(conn);
                throw new ServletException();
            } finally {
                ConnectionUtils.closeQuietly(conn);
            }
        }
        //With commons requests(imgae,css,html...)
        //No need to open the connection.
        else {
            //Allow request to go forward
            //(Go to the next filter or target)
            try {
                chain.doFilter(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

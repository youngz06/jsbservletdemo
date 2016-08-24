package com.zyoungBlog.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.sound.sampled.AudioFormat;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by youngz on 16-8-24.
 */
@WebFilter(filterName = "endcoingFilter", urlPatterns = {"/*"})
public class EncondingFilter implements Filter {
    public EncondingFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }

    public void destroy() {

    }

    public void doFiilter(ServletRequest request, ServletResponse response,
                          FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}


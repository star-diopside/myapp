package jp.myapp.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletContextHolder {

    private static ThreadLocal<ServletContextHolder> HOLDER = new ThreadLocal<>();
    private ServletContext context;
    private ServletRequest request;
    private ServletResponse response;

    private ServletContextHolder(ServletRequest request, ServletResponse response) {
        this.context = request.getServletContext();
        this.request = request;
        this.response = response;
    }

    public ServletContext getContext() {
        return context;
    }

    public ServletRequest getRequest() {
        return request;
    }

    public ServletResponse getResponse() {
        return response;
    }

    public static void set(ServletRequest request, ServletResponse response) {
        HOLDER.set(new ServletContextHolder(request, response));
    }

    public static ServletContextHolder get() {
        return HOLDER.get();
    }
}

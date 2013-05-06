package jp.myapp.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextHolder {

    private static final ThreadLocal<ServletContextHolder> HOLDER = new ThreadLocal<>();
    private ServletContext context;
    private HttpServletRequest request;
    private HttpServletResponse response;

    private ServletContextHolder(HttpServletRequest request, HttpServletResponse response) {
        this.context = request.getServletContext();
        this.request = request;
        this.response = response;
    }

    public ServletContext getContext() {
        return context;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public static void set(HttpServletRequest request, HttpServletResponse response) {
        HOLDER.set(new ServletContextHolder(request, response));
    }

    public static ServletContextHolder get() {
        return HOLDER.get();
    }
}

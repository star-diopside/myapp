package jp.myapp.web.servlet.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.myapp.web.util.ServletContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

public class ServletContextHoldingFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ServletContextHolder.set(request, response);
        filterChain.doFilter(request, response);
    }
}

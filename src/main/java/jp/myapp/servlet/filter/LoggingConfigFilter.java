package jp.myapp.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.MDC;

public class LoggingConfigFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();

        // MDC の情報をクリアする。
        MDC.clear();

        // MDC に情報をセットする。
        MDC.put("sessionId", session.getId());
        MDC.put("remoteAddr", request.getRemoteAddr());

        chain.doFilter(request, response);
    }
}

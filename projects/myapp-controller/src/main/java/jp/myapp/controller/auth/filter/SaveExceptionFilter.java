package jp.myapp.controller.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.myapp.controller.util.SaveExceptionUtils;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.OncePerRequestFilter;

public class SaveExceptionFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        try {
            AuthenticationException exception = SaveExceptionUtils.getSession(session);

            // セッションに例外情報が格納されている場合
            if (exception != null) {
                // リクエスト情報に例外情報を格納する。
                SaveExceptionUtils.setRequest(request, exception);
                SaveExceptionUtils.removeSession(session);
            }

            // 後続の処理を続行する。
            filterChain.doFilter(request, response);

        } catch (AuthenticationException e) {
            // 例外情報をセッションに格納する。
            SaveExceptionUtils.setSession(session, e);

            // 例外を再スローする。
            throw e;
        }
    }
}

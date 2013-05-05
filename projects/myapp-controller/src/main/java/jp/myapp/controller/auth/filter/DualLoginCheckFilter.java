package jp.myapp.controller.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.myapp.bean.userdetails.LoginUser;
import jp.myapp.controller.auth.form.AA01S010Form;
import jp.myapp.controller.auth.form.AA01S010FormImpl;
import jp.myapp.controller.util.SessionUtils;
import jp.myapp.service.auth.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class DualLoginCheckFilter extends OncePerRequestFilter {

    @Autowired
    private UserManager userManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 認証情報を取得する。
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // 認証が行われている場合
        if (principal instanceof LoginUser) {

            LoginUser user = (LoginUser) principal;

            try {
                // 二重ログインチェックを行う。
                this.userManager.checkDualLogin(user);

            } catch (AuthenticationException e) {
                // 認証エラーが発生した場合、例外情報をセッションに格納する。
                AA01S010Form form = new AA01S010FormImpl();
                form.setUserId(request.getParameter(user.getUser().getUserId()));
                form.setException(e);
                (new SessionUtils(request)).setForm(form);

                // 例外を再スローする。
                throw e;
            }
        }

        filterChain.doFilter(request, response);
    }
}

package jp.myapp.web.controller.auth.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.myapp.service.bean.userdetails.LoginUser;
import jp.myapp.service.logic.auth.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
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

        // 認証が行われている場合、二重ログインチェックを行う。
        if (principal instanceof LoginUser) {
            this.userManager.checkDualLogin((LoginUser) principal);
        }

        filterChain.doFilter(request, response);
    }
}

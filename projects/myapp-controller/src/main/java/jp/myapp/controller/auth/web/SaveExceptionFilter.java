package jp.myapp.controller.auth.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.myapp.constant.FlashScopeKeys;
import jp.myapp.servlet.support.FlashScopeUtils;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.FlashMap;

public class SaveExceptionFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            // 後続の処理を続行する。
            filterChain.doFilter(request, response);

        } catch (Exception e) {
            // 例外情報をフラッシュスコープに格納する。
            FlashMap outputFlashMap = FlashScopeUtils.getOutputFlashMap(request);
            outputFlashMap.put(FlashScopeKeys.LAST_EXCEPTION, e);

            // 例外を再スローする。
            throw e;
        }
    }
}

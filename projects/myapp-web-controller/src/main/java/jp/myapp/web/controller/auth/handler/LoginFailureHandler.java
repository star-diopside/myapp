package jp.myapp.web.controller.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.myapp.web.constant.FlashScopeKeys;
import jp.myapp.web.servlet.support.FlashScopeUtils;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.servlet.FlashMap;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        // 例外情報をフラッシュスコープに格納する。
        FlashMap outputFlashMap = FlashScopeUtils.getOutputFlashMap(request);
        outputFlashMap.put(FlashScopeKeys.LAST_EXCEPTION, exception);

        super.onAuthenticationFailure(request, response, exception);
    }
}

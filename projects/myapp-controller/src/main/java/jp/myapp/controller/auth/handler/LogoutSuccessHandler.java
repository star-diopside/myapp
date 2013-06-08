package jp.myapp.controller.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.myapp.bean.userdetails.LoginUser;
import jp.myapp.service.auth.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Autowired
    private UserManager userManager;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        LoginUser user = (LoginUser) authentication.getPrincipal();
        this.userManager.logout(user);

        super.onLogoutSuccess(request, response, authentication);
    }
}

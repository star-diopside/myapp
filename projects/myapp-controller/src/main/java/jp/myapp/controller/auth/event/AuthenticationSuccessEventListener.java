package jp.myapp.controller.auth.event;

import jp.myapp.bean.userdetails.LoginUser;
import jp.myapp.service.auth.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Controller;

/**
 * ログイン成功時の処理を行うイベントリスナー
 */
@Controller
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private UserManager userManager;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {

        // ログイン成功時の処理を行う。
        LoginUser user = (LoginUser) event.getAuthentication().getPrincipal();
        this.userManager.loginSuccess(user.getUsername());
    }
}

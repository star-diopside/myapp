package jp.myapp.controller.auth.event;

import jp.myapp.service.auth.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Controller;

/**
 * ログイン認証エラー時の処理を行うイベントリスナー
 */
@Controller
public class AuthenticationFailureBadCredentialsEventListener implements
        ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    private UserManager userManager;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {

        // 認証エラー処理を行う。
        String userId = event.getAuthentication().getName();
        this.userManager.loginFailure(userId);
    }
}

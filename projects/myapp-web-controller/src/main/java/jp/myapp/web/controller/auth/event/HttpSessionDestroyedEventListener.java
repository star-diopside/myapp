package jp.myapp.web.controller.auth.event;

import jp.myapp.service.bean.userdetails.LoginUser;
import jp.myapp.service.logic.auth.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Controller;

/**
 * セッション破棄時の処理を行うイベントリスナー
 */
@Controller
public class HttpSessionDestroyedEventListener implements ApplicationListener<HttpSessionDestroyedEvent> {

    @Autowired
    private UserManager userManager;

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent event) {

        for (SecurityContext context : event.getSecurityContexts()) {

            // セキュリティコンテキストから認証情報を取得する。
            Object principal = context.getAuthentication().getPrincipal();

            // 認証情報をもとにログアウト処理を行う。
            if (principal instanceof LoginUser) {
                this.userManager.logout((LoginUser) principal);
            }
        }
    }
}

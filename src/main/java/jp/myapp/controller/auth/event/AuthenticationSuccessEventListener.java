package jp.myapp.controller.auth.event;

import jp.myapp.interceptor.LoggingInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    /** ロガー */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        LOGGER.info("ログインに成功しました。(" + event.getAuthentication().getPrincipal() + ")");
    }
}

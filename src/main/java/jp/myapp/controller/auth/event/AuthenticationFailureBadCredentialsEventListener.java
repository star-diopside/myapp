package jp.myapp.controller.auth.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;

public class AuthenticationFailureBadCredentialsEventListener implements
        ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    /** ロガー */
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFailureBadCredentialsEventListener.class);

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        LOGGER.error("ログインに失敗しました。", event.getException());
    }
}

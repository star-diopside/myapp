package jp.myapp.controller.auth.event;

import jp.myapp.interceptor.LoggingInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;

public class AuthenticationFailureBadCredentialsEventListener implements
        ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    /** ���K�[ */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        LOGGER.error("���O�C���Ɏ��s���܂����B", event.getException());
    }
}

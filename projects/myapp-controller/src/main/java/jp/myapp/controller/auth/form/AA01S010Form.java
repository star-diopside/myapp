package jp.myapp.controller.auth.form;

import org.springframework.security.core.AuthenticationException;

public interface AA01S010Form {

    String getUserId();

    void setUserId(String userId);

    String getPassword();

    void setPassword(String password);

    AuthenticationException getException();

    void setException(AuthenticationException exception);

}

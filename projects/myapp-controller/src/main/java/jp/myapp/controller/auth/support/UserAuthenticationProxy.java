package jp.myapp.controller.auth.support;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserAuthenticationProxy extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 1L;

    public UserAuthenticationProxy(UsernamePasswordAuthenticationToken token) {
        super(token.getPrincipal(), token.getCredentials(), token.getAuthorities());
    }
}

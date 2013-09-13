package jp.myapp.web.controller.auth.support;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class UserAuthenticationManagerProxy implements AuthenticationManager {

    private AuthenticationManager parent;

    public UserAuthenticationManagerProxy(AuthenticationManager parent) {
        this.parent = parent;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Authentication token;

        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            token = new UserAuthenticationProxy((UsernamePasswordAuthenticationToken) authentication);
        } else {
            token = authentication;
        }

        return parent.authenticate(token);
    }
}

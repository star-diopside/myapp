package jp.myapp.controller.auth.checker;

import jp.myapp.bean.userdetails.LoginUser;
import jp.myapp.service.auth.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

public class BeforeLoginUserChecker implements UserDetailsChecker {

    @Autowired
    private UserManager userManager;

    @Override
    public void check(UserDetails toCheck) {
        this.userManager.checkValid((LoginUser) toCheck);
    }
}

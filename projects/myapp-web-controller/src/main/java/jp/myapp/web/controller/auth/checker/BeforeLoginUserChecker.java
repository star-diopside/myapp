package jp.myapp.web.controller.auth.checker;

import jp.myapp.service.bean.userdetails.LoginUser;
import jp.myapp.service.logic.auth.UserManager;

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

package jp.myapp.bean.userdetails;

import jp.myapp.data.entity.Users;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserImpl extends User implements LoginUser {

    private static final long serialVersionUID = 1L;

    private Users user;

    public LoginUserImpl(Users user) {
        super(user.getUserId(), user.getPassword(), user.getEnabled(), true, true, true, AuthorityUtils.NO_AUTHORITIES);
        this.user = user;
    }

    public LoginUserImpl(UserDetails user, LoginUser loginUser) {
        super(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
                user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
        this.user = loginUser.getUser();
    }

    @Override
    public Users getUser() {
        return this.user;
    }

    @Override
    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("; ").append("User: ").append(this.user);
        return sb.toString();
    }
}

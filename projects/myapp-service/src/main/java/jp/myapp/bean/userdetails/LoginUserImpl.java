package jp.myapp.bean.userdetails;

import java.sql.Timestamp;

import jp.myapp.data.entity.Users;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserImpl extends User implements LoginUser {

    private static final long serialVersionUID = 1L;

    private String displayName;
    private Timestamp lastLoginDatetime;
    private Timestamp logoutDatetime;
    private Integer version;

    public LoginUserImpl(Users user) {
        super(user.getUserId(), user.getPassword(), user.getEnabled(), true, true, true, AuthorityUtils.NO_AUTHORITIES);
        this.displayName = user.getUsername();
        this.lastLoginDatetime = user.getLastLoginDatetime();
        this.logoutDatetime = user.getLogoutDatetime();
        this.version = user.getVersion();
    }

    public LoginUserImpl(UserDetails user, LoginUser loginUser) {
        super(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
                user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
        this.displayName = loginUser.getDisplayName();
        this.lastLoginDatetime = loginUser.getLastLoginDatetime();
        this.logoutDatetime = loginUser.getLogoutDatetime();
        this.version = loginUser.getVersion();
    }

    @Override
    public String getUserId() {
        return super.getUsername();
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public Timestamp getLastLoginDatetime() {
        return this.lastLoginDatetime;
    }

    @Override
    public void setLastLoginDatetime(Timestamp lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    @Override
    public Timestamp getLogoutDatetime() {
        return this.logoutDatetime;
    }

    @Override
    public void setLogoutDatetime(Timestamp logoutDatetime) {
        this.logoutDatetime = logoutDatetime;
    }

    @Override
    public Integer getVersion() {
        return this.version;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("; ").append("DisplayName: ").append(this.displayName);
        sb.append("; ").append("LastLoginDatetime: ").append(this.lastLoginDatetime);
        sb.append("; ").append("LogoutDatetime: ").append(this.logoutDatetime);
        sb.append("; ").append("Version: ").append(this.version);
        return sb.toString();
    }
}

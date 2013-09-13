package jp.myapp.service.bean.userdetails;

import java.sql.Timestamp;

import jp.myapp.data.entity.management.Users;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserImpl extends User implements LoginUser {

    private static final long serialVersionUID = 1L;

    private String displayName;
    private Timestamp lastLoginTimestamp;
    private Timestamp logoutTimestamp;
    private Integer version;

    public LoginUserImpl(Users user) {
        super(user.getUserId(), user.getPassword(), user.getEnabled(), true, true,
                (user.getLockoutTimestamp() == null), AuthorityUtils.NO_AUTHORITIES);
        this.displayName = user.getUsername();
        this.lastLoginTimestamp = user.getLastLoginTimestamp();
        this.logoutTimestamp = user.getLogoutTimestamp();
        this.version = user.getVersion();
    }

    public LoginUserImpl(UserDetails user, LoginUser loginUser) {
        super(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
                user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
        this.displayName = loginUser.getDisplayName();
        this.lastLoginTimestamp = loginUser.getLastLoginTimestamp();
        this.logoutTimestamp = loginUser.getLogoutTimestamp();
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
    public Timestamp getLastLoginTimestamp() {
        return this.lastLoginTimestamp;
    }

    @Override
    public void setLastLoginTimestamp(Timestamp lastLoginTimestamp) {
        this.lastLoginTimestamp = lastLoginTimestamp;

    }

    @Override
    public Timestamp getLogoutTimestamp() {
        return this.logoutTimestamp;
    }

    @Override
    public void setLogoutTimestamp(Timestamp logoutTimestamp) {
        this.logoutTimestamp = logoutTimestamp;
    }

    @Override
    public Integer getVersion() {
        return this.version;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("; ").append("DisplayName: ").append(this.displayName);
        sb.append("; ").append("LastLoginTimestamp: ").append(this.lastLoginTimestamp);
        sb.append("; ").append("LogoutTimestamp: ").append(this.logoutTimestamp);
        sb.append("; ").append("Version: ").append(this.version);
        return sb.toString();
    }
}

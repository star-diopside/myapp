package jp.myapp.bean.userdetails;

import java.sql.Timestamp;

import jp.myapp.data.entity.Users;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserImpl extends User implements LoginUser {

    private static final long serialVersionUID = 1L;

    private String displayName;
    private Timestamp passwordUpdatedDatetime;
    private boolean provisionalRegistration;
    private Integer loginErrorCount;
    private Timestamp lastLoginDatetime;
    private Timestamp logoutDatetime;
    private Integer version;

    public LoginUserImpl(UserDetails user, String displayName, Timestamp passwordUpdatedDatetime,
            boolean provisionalRegistration, Integer loginErrorCount, Timestamp lastLoginDatetime,
            Timestamp logoutDatetime, Integer version) {
        super(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
                user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
        this.displayName = displayName;
        this.passwordUpdatedDatetime = passwordUpdatedDatetime;
        this.provisionalRegistration = provisionalRegistration;
        this.loginErrorCount = loginErrorCount;
        this.lastLoginDatetime = lastLoginDatetime;
        this.logoutDatetime = logoutDatetime;
        this.version = version;
    }

    public LoginUserImpl(Users user) {
        super(user.getUserId(), user.getPassword(), user.getEnabled(), true, true, true, AuthorityUtils.NO_AUTHORITIES);
        this.displayName = user.getUsername();
        this.passwordUpdatedDatetime = user.getPasswordUpdatedDatetime();
        this.provisionalRegistration = user.getProvisionalRegistration();
        this.loginErrorCount = user.getLoginErrorCount();
        this.lastLoginDatetime = user.getLastLoginDatetime();
        this.logoutDatetime = user.getLogoutDatetime();
        this.version = user.getVersion();
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public Timestamp getPasswordUpdatedDatetime() {
        return this.passwordUpdatedDatetime;
    }

    @Override
    public boolean isProvisionalRegistration() {
        return this.provisionalRegistration;
    }

    @Override
    public Integer getLoginErrorCount() {
        return this.loginErrorCount;
    }

    @Override
    public Timestamp getLastLoginDatetime() {
        return this.lastLoginDatetime;
    }

    @Override
    public Timestamp getLogoutDatetime() {
        return this.logoutDatetime;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public Object getSalt() {
        return this.passwordUpdatedDatetime;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(super.toString());

        sb.append("; ").append("DisplayName: ").append(this.displayName);
        sb.append("; ").append("PasswordUpdatedDatetime: ").append(this.passwordUpdatedDatetime);
        sb.append("; ").append("ProvisionalRegistration: ").append(this.provisionalRegistration);
        sb.append("; ").append("LoginErrorCount: ").append(this.loginErrorCount);
        sb.append("; ").append("LastLoginDatetime: ").append(this.lastLoginDatetime);
        sb.append("; ").append("LogoutDatetime: ").append(this.logoutDatetime);

        return sb.toString();
    }
}

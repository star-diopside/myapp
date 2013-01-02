package jp.myapp.bean.userdetails;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserImpl extends User implements LoginUser {

    private static final long serialVersionUID = 1L;

    private String displayName;
    private Timestamp passwordUpdatedDatetime;
    private boolean provisionalRegistration;
    private Timestamp lastLogin;

    public LoginUserImpl(String username, String displayName, String password, Timestamp passwordUpdatedDatetime,
            boolean enabled, boolean provisionalRegistration, Timestamp lastLogin, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.displayName = displayName;
        this.passwordUpdatedDatetime = passwordUpdatedDatetime;
        this.provisionalRegistration = provisionalRegistration;
        this.lastLogin = lastLogin;
    }

    public LoginUserImpl(UserDetails user, String displayName, Timestamp passwordUpdatedDatetime,
            boolean provisionalRegistration, Timestamp lastLogin) {

        this(user.getUsername(), displayName, user.getPassword(), passwordUpdatedDatetime, user.isEnabled(),
                provisionalRegistration, lastLogin, user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isAccountNonLocked(), user.getAuthorities());
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
    public Timestamp getLastLogin() {
        return this.lastLogin;
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
        sb.append("; ").append("LastLogin: ").append(this.lastLogin);

        return sb.toString();
    }
}

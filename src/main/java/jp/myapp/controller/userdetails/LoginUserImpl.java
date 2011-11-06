package jp.myapp.controller.userdetails;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserImpl extends User implements LoginUser {

    private static final long serialVersionUID = 4141575890493184275L;

    private String displayName;
    private boolean provisionalRegistration;
    private Date lastLogin;

    public LoginUserImpl(String username, String displayName, String password, boolean enabled,
            boolean provisionalRegistration, Date lastLogin, boolean accountNonExpired, boolean credentialsNonExpired,
            boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.displayName = displayName;
        this.provisionalRegistration = provisionalRegistration;
        this.lastLogin = lastLogin;
    }

    public LoginUserImpl(UserDetails user, String displayName, boolean provisionalRegistration, Date lastLogin) {

        this(user.getUsername(), displayName, user.getPassword(), user.isEnabled(), provisionalRegistration, lastLogin,
                user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(),
                user.getAuthorities());
    }

    /**
     * 表示名を取得する。
     * 
     * @return 表示名
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * 仮登録フラグを取得する。
     * 
     * @return 仮登録フラグ
     */
    @Override
    public boolean isProvisionalRegistration() {
        return this.provisionalRegistration;
    }

    /**
     * 最終ログイン日時を取得する。
     * 
     * @return 最終ログイン日時
     */
    @Override
    public Date getLastLogin() {
        return this.lastLogin;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(super.toString());

        sb.append("; ").append("DisplayName: ").append(this.displayName);
        sb.append("; ").append("ProvisionalRegistration: ").append(this.provisionalRegistration);
        sb.append("; ").append("LastLogin: ").append(this.lastLogin);

        return sb.toString();
    }
}

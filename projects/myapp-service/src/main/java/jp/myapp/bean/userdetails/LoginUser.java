package jp.myapp.bean.userdetails;

import jp.myapp.data.entity.Users;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * ログインユーザ情報を示すインタフェース
 */
public interface LoginUser extends UserDetails {

    /**
     * ユーザ情報を取得する。
     * 
     * @return ユーザ情報
     */
    Users getUser();

    /**
     * ユーザ情報を設定する。
     * 
     * @param user ユーザ情報
     */
    void setUser(Users user);

}

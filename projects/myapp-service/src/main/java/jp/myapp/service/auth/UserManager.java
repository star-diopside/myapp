package jp.myapp.service.auth;

import org.springframework.security.core.AuthenticationException;

import jp.myapp.bean.userdetails.LoginUser;

public interface UserManager {

    /**
     * 取得したユーザ情報が有効かどうか判定する。
     * 
     * @param user ユーザ情報
     * @throws AuthenticationException 無効なユーザ情報と判定した場合
     */
    void checkValid(LoginUser user) throws AuthenticationException;

    /**
     * ログイン成功時の処理を行う。
     * 
     * @param user ユーザ情報
     */
    void loginSuccess(LoginUser user);

    /**
     * ログイン失敗時の処理を行う。
     * 
     * @param userId ユーザID
     */
    void loginFailure(String userId);

    /**
     * ログアウト処理を行う。
     * 
     * @param user ユーザ情報
     */
    void logout(LoginUser user);

}

package jp.myapp.service.logic.auth;

import jp.myapp.service.bean.userdetails.LoginUser;

import org.springframework.security.core.AuthenticationException;

public interface UserManager {

    /**
     * 取得したユーザ情報が有効かどうか判定する。
     * 
     * @param loginUser ユーザ情報
     * @throws AuthenticationException 無効なユーザ情報と判定した場合
     */
    void checkValid(LoginUser loginUser) throws AuthenticationException;

    /**
     * ログイン成功時の処理を行う。
     * 
     * @param loginUser ユーザ情報
     */
    void loginSuccess(LoginUser loginUser);

    /**
     * ログイン失敗時の処理を行う。
     * 
     * @param userId ユーザID
     */
    void loginFailure(String userId);

    /**
     * ログアウト処理を行う。
     * 
     * @param loginUser ユーザ情報
     */
    void logout(LoginUser loginUser);

    /**
     * 二重ログインチェックを行う。
     * 
     * @param loginUser ユーザ情報
     * @throws AuthenticationException 認証エラーが発生した場合
     */
    void checkDualLogin(LoginUser loginUser) throws AuthenticationException;

}

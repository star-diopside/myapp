package jp.myapp.service.auth;

public interface UserManager {

    /**
     * ログイン成功時の処理を行う。
     * 
     * @param userId ユーザID
     */
    void loginSuccess(String userId);

    /**
     * ログイン失敗時の処理を行う。
     * 
     * @param userId ユーザID
     */
    void loginFailure(String userId);

    /**
     * ログアウト処理を行う。
     * 
     * @param userId ユーザID
     */
    void logout(String userId);

}

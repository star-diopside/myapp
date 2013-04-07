package jp.myapp.service;

import jp.myapp.bean.UserInfo;
import jp.myapp.exception.ApplicationException;
import jp.myapp.exception.BusinessException;

public interface LoginService {

    /**
     * ユーザ認証処理を行う。
     * 
     * @param userId ユーザID
     * @param password パスワード
     * @return ログインユーザ情報
     * @throws BusinessException 認証エラーが発生した場合
     * @throws ApplicationException ユーザ有効期限切れの場合
     */
    UserInfo loginUser(String userId, String password) throws BusinessException, ApplicationException;

    /**
     * ユーザ登録処理を行う。
     * 
     * @param userId ユーザID
     * @param userName ユーザ名
     * @param password パスワード
     * @throws BusinessException 指定されたユーザ情報での登録が行えない場合
     */
    void registerUser(String userId, String userName, String password) throws BusinessException;

}

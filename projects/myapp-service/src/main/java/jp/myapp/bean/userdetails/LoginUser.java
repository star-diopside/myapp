package jp.myapp.bean.userdetails;

import java.sql.Timestamp;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * ログインユーザ情報を示すインタフェース
 */
public interface LoginUser extends UserDetails {

    /**
     * ユーザ表示名を取得する。
     * 
     * @return ユーザ表示名
     */
    String getDisplayName();

    /**
     * パスワード更新日時を取得する。
     * 
     * @return パスワード更新日時
     */
    Timestamp getPasswordUpdatedDatetime();

    /**
     * 仮登録フラグを取得する。
     * 
     * @return 仮登録フラグ
     */
    boolean isProvisionalRegistration();

    /**
     * ログインエラー回数を取得する。
     * 
     * @return ログインエラー回数
     */
    Integer getLoginErrorCount();

    /**
     * 最終ログイン日時を取得する。
     * 
     * @return 最終ログイン日時
     */
    Timestamp getLastLoginDatetime();

    /**
     * ログアウト日時を取得する。
     * 
     * @return ログアウト日時
     */
    Timestamp getLogoutDatetime();

    /**
     * バージョンを取得する。
     * 
     * @return バージョン
     */
    Integer getVersion();

    /**
     * パスワードハッシュのソルトを取得する。
     * 
     * @return ソルト
     */
    Object getSalt();

}

package jp.myapp.bean.userdetails;

import java.sql.Timestamp;

/**
 * ログインユーザ情報を示すインタフェース
 */
public interface LoginUser {

    /**
     * ユーザIDを取得する。
     * 
     * @return ユーザID
     */
    String getUserId();

    /**
     * ユーザ表示名を取得する。
     * 
     * @return ユーザ表示名
     */
    String getDisplayName();

    /**
     * 最終ログイン日時を取得する。
     * 
     * @return 最終ログイン日時
     */
    Timestamp getLastLoginTimestamp();

    /**
     * 最終ログイン日時を設定する。
     * 
     * @param lastLoginTimestamp 最終ログイン日時
     */
    void setLastLoginTimestamp(Timestamp lastLoginTimestamp);

    /**
     * ログアウト日時を取得する。
     * 
     * @return ログアウト日時
     */
    Timestamp getLogoutTimestamp();

    /**
     * ログアウト日時を設定する。
     * 
     * @param logoutTimestamp ログアウト日時
     */
    void setLogoutTimestamp(Timestamp logoutTimestamp);

    /**
     * バージョンを取得する。
     * 
     * @return バージョン
     */
    Integer getVersion();

}

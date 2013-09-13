package jp.myapp.web.constant;

/**
 * フラッシュスコープに使用するキー定数
 */
public final class FlashScopeKeys {

    private FlashScopeKeys() {
    }

    /** 最終例外情報 */
    public static final String LAST_EXCEPTION = "LAST_EXCEPTION";

    /** セッションタイムアウトフラグ */
    public static final String INVALID_SESSION_FLAG = "INVALID_SESSION_FLAG";
}

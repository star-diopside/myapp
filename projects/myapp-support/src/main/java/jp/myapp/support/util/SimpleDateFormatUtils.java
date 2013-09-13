package jp.myapp.support.util;

import java.text.SimpleDateFormat;

/**
 * {@link SimpleDateFormat}に関するユーティリティクラス
 */
public final class SimpleDateFormatUtils {

    private SimpleDateFormatUtils() {
    }

    /**
     * <code>yyyyMMddHHmmssSSS</code>形式の{@link SimpleDateFormat}を取得する。
     */
    public static final ThreadLocal<SimpleDateFormat> FORMATTER_YYYYMMDDHHMMSSSSS = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmssSSS");
        }
    };
}

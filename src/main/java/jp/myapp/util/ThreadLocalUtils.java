package jp.myapp.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ThreadLocalUtils {

    private ThreadLocalUtils() {
    }

    public static final ThreadLocal<SimpleDateFormat> FORMATTER_YYYYMMDD = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static final ThreadLocal<SimpleDateFormat> FORMATTER_HHMMSS = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HHmmss");
        }
    };

    public static final ThreadLocal<SimpleDateFormat> FORMATTER_YYYYMMDDHHMMSS = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmss");
        }
    };

    public static final ThreadLocal<SimpleDateFormat> FORMATTER_RFC1123 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        }
    };
}

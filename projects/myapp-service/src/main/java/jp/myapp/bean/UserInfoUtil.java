package jp.myapp.bean;

import java.util.concurrent.TimeUnit;

import jp.myapp.data.entity.management.Users;

public final class UserInfoUtil {

    private UserInfoUtil() {
    }

    /**
     * 有効なユーザ情報かどうかチェックする。
     * 
     * @return 有効ユーザの場合は true、無効ユーザの場合は false を返す。
     */
    public static boolean isValid(Users user) {

        if (Boolean.FALSE.equals(user.getInterimRegister())) {
            // 本登録済みの場合、有効ユーザとする。
            return true;

        } else {
            // 仮登録中の場合、登録後１日経過すると無効ユーザとする。
            long duration = System.currentTimeMillis() - user.getRegisterTimestamp().getTime();
            return (duration <= TimeUnit.DAYS.toMillis(1));
        }
    }
}

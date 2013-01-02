package jp.myapp.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.beanutils.PropertyUtils;

import jp.myapp.dao.entity.Users;
import jp.myapp.dao.entity.UsersImpl;

public class UserInfo extends UsersImpl {

    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ
     */
    public UserInfo() {
    }

    /**
     * コピーコンストラクタ
     * 
     * @param source コピーするユーザ情報
     */
    public UserInfo(Users source) {
        try {
            PropertyUtils.copyProperties(this, source);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 有効なユーザ情報かどうかチェックする。
     * 
     * @return 有効ユーザの場合は true、無効ユーザの場合は false を返す。
     */
    public boolean isValid() {

        if (Boolean.FALSE.equals(this.getProvisionalRegistration())) {
            // 本登録済みの場合、有効ユーザとする。
            return true;

        } else {
            // 仮登録中の場合、登録後１日経過すると無効ユーザとする。
            long duration = System.currentTimeMillis() - this.getRegisterDatetime().getTime();

            if (duration <= TimeUnit.DAYS.toMillis(1)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * パスワードハッシュのソルトを取得する。
     * 
     * @return ソルト
     */
    public Object getSalt() {
        return this.getPasswordUpdatedDatetime();
    }
}

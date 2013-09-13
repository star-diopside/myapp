package jp.myapp.service.exception.auth;

import org.springframework.security.authentication.AccountStatusException;

/**
 * 二重ログインエラーが発生したことを示す例外クラス
 */
public class DualLoginException extends AccountStatusException {

    private static final long serialVersionUID = 1L;

    public DualLoginException() {
        super("Dual login exception has occurred.");
    }

    public DualLoginException(Throwable cause) {
        super("Dual login exception has occurred.", cause);
    }
}

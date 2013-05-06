package jp.myapp.controller.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;

public final class SaveExceptionUtils {

    private static final String SAVE_EXCEPTION_REQUEST_KEY = SaveExceptionUtils.class.getName() + ".REQUEST_KEY";
    private static final String SAVE_EXCEPTION_SESSION_KEY = SaveExceptionUtils.class.getName() + ".SESSION_KEY";

    /**
     * リクエストから例外情報を取得する。
     * 
     * @param request リクエスト
     * @return 例外情報
     */
    public static AuthenticationException getRequest(HttpServletRequest request) {

        Object exception = request.getAttribute(SAVE_EXCEPTION_REQUEST_KEY);

        if (exception instanceof AuthenticationException) {
            return (AuthenticationException) exception;
        } else {
            return null;
        }
    }

    /**
     * 例外情報をリクエストに格納する。
     * 
     * @param request リクエスト
     * @param e 例外情報
     */
    public static void setRequest(HttpServletRequest request, AuthenticationException e) {
        request.setAttribute(SAVE_EXCEPTION_REQUEST_KEY, e);
    }

    /**
     * 例外情報をリクエストから削除する。
     * 
     * @param request リクエスト
     */
    public static void removeRequest(HttpServletRequest request) {
        request.removeAttribute(SAVE_EXCEPTION_REQUEST_KEY);
    }

    /**
     * セッションから例外情報を取得する。
     * 
     * @param session セッション
     * @return 例外情報
     */
    public static AuthenticationException getSession(HttpSession session) {

        Object exception = session.getAttribute(SAVE_EXCEPTION_SESSION_KEY);

        if (exception instanceof AuthenticationException) {
            return (AuthenticationException) exception;
        } else {
            return null;
        }
    }

    /**
     * 例外情報をセッションに格納する。
     * 
     * @param session セッション
     * @param e 例外情報
     */
    public static void setSession(HttpSession session, AuthenticationException e) {
        session.setAttribute(SAVE_EXCEPTION_SESSION_KEY, e);
    }

    /**
     * 例外情報をセッションから削除する。
     * 
     * @param session セッション
     */
    public static void removeSession(HttpSession session) {
        session.removeAttribute(SAVE_EXCEPTION_SESSION_KEY);
    }
}

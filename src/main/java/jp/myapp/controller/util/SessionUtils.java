package jp.myapp.controller.util;

import java.util.Map;

/**
 * フォームデータをセッション引き継ぎを行うためのユーティリティクラス
 */
public final class SessionUtils {

    private static final String TRANSITION_FORM_KEY = "TRANSITION_FORM_KEY";
    private Map<String, Object> session;

    public SessionUtils(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * フォームの型を指定してセッションからフォームデータを取得する。
     * 
     * @param formType フォームの型
     * @return セッションから取得したフォームデータ。セッションに存在しない場合はnull。
     */
    public <T> T getForm(Class<T> formType) {

        Object form = this.session.get(TRANSITION_FORM_KEY);

        if (formType.isInstance(form)) {
            return formType.cast(form);
        }

        return null;
    }

    /**
     * セッションにフォームデータを設定する。
     * 
     * @param form セッションに登録するフォームデータ
     */
    public void setForm(Object form) {
        this.session.put(TRANSITION_FORM_KEY, form);
    }

    /**
     * セッションからフォームデータを削除する。
     */
    public void removeForm() {
        this.session.remove(TRANSITION_FORM_KEY);
    }
}

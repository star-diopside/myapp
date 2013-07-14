package jp.myapp.webservice_client.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class LoginForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ユーザ名 */
    @NotNull(message = "{jp.myapp.webservice_client.controller.Required.username.message}")
    @NotBlank(message = "{jp.myapp.webservice_client.controller.Required.username.message}")
    private String username;

    /** パスワード */
    @NotNull(message = "{jp.myapp.webservice_client.controller.Required.password.message}")
    @NotBlank(message = "{jp.myapp.webservice_client.controller.Required.password.message}")
    private String password;

    /** エラー有無 */
    private boolean error = false;

    /**
     * ユーザ名を取得する。
     * 
     * @return ユーザ名
     */
    public String getUsername() {
        return username;
    }

    /**
     * ユーザ名を設定する。
     * 
     * @param username ユーザ名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * パスワードを取得する。
     * 
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを設定する。
     * 
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * エラー有無を取得する。
     * 
     * @return エラー有無
     */
    public boolean isError() {
        return error;
    }

    /**
     * エラー有無を設定する。
     * 
     * @param error エラー有無
     */
    public void setError(boolean error) {
        this.error = error;
    }
}

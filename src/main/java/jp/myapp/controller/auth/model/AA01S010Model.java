package jp.myapp.controller.auth.model;

import jp.myapp.controller.auth.form.AA01S010Form;

public interface AA01S010Model {

    AA01S010Form getAA01S010Form();

    void setAA01S010Form(AA01S010Form form);

    String getJ_username();

    void setJ_username(String j_username);

    String getJ_password();

    void setJ_password(String j_password);

    Boolean getLoginError();

    void setLoginError(Boolean loginError);

}

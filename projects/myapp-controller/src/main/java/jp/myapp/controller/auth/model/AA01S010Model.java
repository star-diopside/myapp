package jp.myapp.controller.auth.model;

import jp.myapp.controller.auth.form.AA01S010Form;

public interface AA01S010Model {

    AA01S010Form getAA01S010Form();

    void setAA01S010Form(AA01S010Form form);

    String getUserId();

    void setUserId(String userId);

    String getPassword();

    void setPassword(String password);

}

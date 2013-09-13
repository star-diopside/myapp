package jp.myapp.web.controller.auth.model;

import jp.myapp.web.controller.auth.form.AA01S010Form;
import jp.myapp.web.controller.auth.form.AA02S010Form;

public interface AA02S010RegisterModel {

    AA02S010Form getAA02S010Form();

    void setAA02S010Form(AA02S010Form form);

    AA01S010Form getAA01S010Form();

    void setAA01S010Form(AA01S010Form form);

}

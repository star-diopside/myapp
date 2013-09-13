package jp.myapp.web.controller.edit.model;

import jp.myapp.web.controller.common.form.LocaleForm;
import jp.myapp.web.controller.edit.form.A01Form;
import jp.myapp.web.controller.edit.form.A02Form;

public interface A01LoginModel {

    LocaleForm getLocaleForm();

    void setLocaleForm(LocaleForm localeForm);

    A01Form getA01Form();

    void setA01Form(A01Form a01Form);

    A02Form getA02Form();

    void setA02Form(A02Form a02Form);

}

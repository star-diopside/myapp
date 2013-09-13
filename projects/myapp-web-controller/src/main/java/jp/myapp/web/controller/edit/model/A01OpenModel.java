package jp.myapp.web.controller.edit.model;

import jp.myapp.web.controller.common.form.LocaleForm;
import jp.myapp.web.controller.edit.form.A01Form;

public interface A01OpenModel {

    LocaleForm getLocaleForm();

    void setLocaleForm(LocaleForm localeForm);

    A01Form getA01Form();

    void setA01Form(A01Form a01Form);

}

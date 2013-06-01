package jp.myapp.controller.edit.model;

import jp.myapp.controller.common.form.LocaleForm;
import jp.myapp.controller.edit.form.A01Form;
import jp.myapp.controller.edit.form.A03Form;

public interface A01RegisterModel {

    LocaleForm getLocaleForm();

    void setLocaleForm(LocaleForm localeForm);

    A01Form getA01Form();

    void setA01Form(A01Form a01Form);

    A03Form getA03Form();

    void setA03Form(A03Form a03Form);

}

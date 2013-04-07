package jp.myapp.controller.edit.model;

import jp.myapp.controller.edit.form.A01Form;
import jp.myapp.controller.edit.form.A03Form;

public interface A03BackModel {

    A03Form getA03Form();

    void setA03Form(A03Form a03Form);

    A01Form getA01Form();

    void setA01Form(A01Form a01Form);

}

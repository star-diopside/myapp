package jp.myapp.controller.edit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.controller.common.form.LocaleForm;
import jp.myapp.controller.common.form.LocaleFormImpl;
import jp.myapp.controller.edit.form.A01Form;
import jp.myapp.controller.edit.form.A01FormImpl;
import jp.myapp.util.Loggable;
import jp.myapp.util.LoggableUtil;

public class A01OpenModelImpl implements A01OpenModel, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    private LocaleForm localeForm = new LocaleFormImpl();
    private A01Form a01Form = new A01FormImpl();

    @Override
    public LocaleForm getLocaleForm() {
        return this.localeForm;
    }

    @Override
    public void setLocaleForm(LocaleForm localeForm) {
        this.localeForm = localeForm;
    }

    @Override
    public A01Form getA01Form() {
        return this.a01Form;
    }

    @Override
    public void setA01Form(A01Form a01Form) {
        this.a01Form = a01Form;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.localeForm, "localeForm");
        LoggableUtil.addLog(list, this.a01Form, "a01Form");

        return list;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, true);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

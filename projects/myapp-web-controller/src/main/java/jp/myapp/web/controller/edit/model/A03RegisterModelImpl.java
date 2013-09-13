package jp.myapp.web.controller.edit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.core.logging.Loggable;
import jp.myapp.core.logging.LoggableUtil;
import jp.myapp.web.controller.edit.form.A02Form;
import jp.myapp.web.controller.edit.form.A02FormImpl;
import jp.myapp.web.controller.edit.form.A03Form;
import jp.myapp.web.controller.edit.form.A03FormImpl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class A03RegisterModelImpl implements A03RegisterModel, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    private A03Form a03Form = new A03FormImpl();
    private A02Form a02Form = new A02FormImpl();

    @Override
    public A03Form getA03Form() {
        return this.a03Form;
    }

    @Override
    public void setA03Form(A03Form a03Form) {
        this.a03Form = a03Form;
    }

    @Override
    public A02Form getA02Form() {
        return this.a02Form;
    }

    @Override
    public void setA02Form(A02Form a02Form) {
        this.a02Form = a02Form;
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.a03Form, "a03Form");
        LoggableUtil.addLog(list, this.a02Form, "a02Form");

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

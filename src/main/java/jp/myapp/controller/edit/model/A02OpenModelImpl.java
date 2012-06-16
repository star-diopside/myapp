package jp.myapp.controller.edit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.controller.edit.form.A02Form;
import jp.myapp.logging.Loggable;
import jp.myapp.logging.LoggableUtil;

public class A02OpenModelImpl implements A02OpenModel, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    private A02Form a02Form;

    @Override
    public A02Form getA02Form() {
        return this.a02Form;
    }

    @Override
    public void setA02Form(A02Form a02Form) {
        this.a02Form = a02Form;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.a02Form, "a02Form");

        return log;
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

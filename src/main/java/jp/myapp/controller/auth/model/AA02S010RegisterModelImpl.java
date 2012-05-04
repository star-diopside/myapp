package jp.myapp.controller.auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.controller.auth.form.AA01S010Form;
import jp.myapp.controller.auth.form.AA01S010FormImpl;
import jp.myapp.controller.auth.form.AA02S010Form;
import jp.myapp.controller.auth.form.AA02S010FormImpl;
import jp.myapp.util.Loggable;
import jp.myapp.util.LoggableUtil;

public class AA02S010RegisterModelImpl implements AA02S010RegisterModel, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    private AA02S010Form AA02S010Form = new AA02S010FormImpl();
    private AA01S010Form AA01S010Form = new AA01S010FormImpl();

    @Override
    public AA02S010Form getAA02S010Form() {
        return this.AA02S010Form;
    }

    @Override
    public void setAA02S010Form(AA02S010Form form) {
        this.AA02S010Form = form;
    }

    @Override
    public AA01S010Form getAA01S010Form() {
        return this.AA01S010Form;
    }

    @Override
    public void setAA01S010Form(AA01S010Form form) {
        this.AA01S010Form = form;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.AA02S010Form, "AA02S010Form");
        LoggableUtil.addLog(list, this.AA01S010Form, "AA01S010Form");

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

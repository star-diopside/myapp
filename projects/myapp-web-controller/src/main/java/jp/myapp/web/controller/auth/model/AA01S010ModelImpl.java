package jp.myapp.web.controller.auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.core.logging.Loggable;
import jp.myapp.core.logging.LoggableUtil;
import jp.myapp.web.controller.auth.form.AA01S010Form;
import jp.myapp.web.controller.auth.form.AA01S010FormImpl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AA01S010ModelImpl implements AA01S010Model, Loggable, Serializable {

    private static final long serialVersionUID = 1L;

    private AA01S010Form AA01S010Form = new AA01S010FormImpl();

    @Override
    public AA01S010Form getAA01S010Form() {
        return this.AA01S010Form;
    }

    @Override
    public void setAA01S010Form(AA01S010Form form) {
        this.AA01S010Form = form;
    }

    @Override
    public String getUserId() {
        return this.AA01S010Form.getUserId();
    }

    @Override
    public void setUserId(String userId) {
        this.AA01S010Form.setUserId(userId);
    }

    @Override
    public String getPassword() {
        return this.AA01S010Form.getPassword();
    }

    @Override
    public void setPassword(String password) {
        this.AA01S010Form.setPassword(password);
    }

    @Override
    public Collection<String> toLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.AA01S010Form, "AA01S010Form");

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

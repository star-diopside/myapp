package jp.myapp.controller.auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import jp.myapp.controller.auth.form.AA01S010Form;
import jp.myapp.controller.auth.form.AA01S010FormImpl;
import jp.myapp.util.Loggable;
import jp.myapp.util.LoggableUtil;

public class AA01S010ModelImpl implements AA01S010Model, Loggable, Serializable {

    private static final long serialVersionUID = 468587860705262943L;

    private AA01S010Form AA01S010Form = new AA01S010FormImpl();
    private Boolean loginError;

    @Override
    public AA01S010Form getAA01S010Form() {
        return this.AA01S010Form;
    }

    @Override
    public void setAA01S010Form(AA01S010Form form) {
        this.AA01S010Form = form;
    }

    @Override
    public String getJ_username() {
        return this.AA01S010Form.getUserId();
    }

    @Override
    public void setJ_username(String j_username) {
        this.AA01S010Form.setUserId(j_username);
    }

    @Override
    public String getJ_password() {
        return this.AA01S010Form.getPassword();
    }

    @Override
    public void setJ_password(String j_password) {
        this.AA01S010Form.setPassword(j_password);
    }

    @Override
    public Boolean getLoginError() {
        return loginError;
    }

    @Override
    public void setLoginError(Boolean loginError) {
        this.loginError = loginError;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> log = new ArrayList<String>();

        LoggableUtil.addLog(log, this.AA01S010Form, "AA01S010Form");
        LoggableUtil.addLog(log, this.loginError, "loginError");

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

package jp.myapp.controller.edit.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.util.Loggable;
import jp.myapp.util.LoggableUtil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class A01FormImpl implements A01Form, Loggable, Serializable {

    private static final long serialVersionUID = -5136237544715207465L;

    /** ���[�UID */
    private String userId;
    /** �p�X���[�h */
    private String password;

    /**
     * ���[�UID���擾����B
     * 
     * @return ���[�UID
     */
    @Override
    public String getUserId() {
        return this.userId;
    }

    /**
     * ���[�UID��ݒ肷��B
     * 
     * @param userId ���[�UID
     */
    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * �p�X���[�h���擾����B
     * 
     * @return �p�X���[�h
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * �p�X���[�h��ݒ肷��B
     * 
     * @param password �p�X���[�h
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.userId, "userId");
        LoggableUtil.addLog(list, this.password, "password");

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

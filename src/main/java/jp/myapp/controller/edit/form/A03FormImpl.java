package jp.myapp.controller.edit.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jp.myapp.util.Loggable;
import jp.myapp.util.LoggableUtil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class A03FormImpl implements A03Form, Loggable, Serializable {

    private static final long serialVersionUID = 9190531531200847613L;

    /** ���[�UID */
    private String userId;
    /** ���[�U�� */
    private String userName;
    /** �p�X���[�h */
    private String password;
    /** Captcha */
    private String captcha;

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
     * ���[�U�����擾����B
     * 
     * @return ���[�U��
     */
    @Override
    public String getUserName() {
        return this.userName;
    }

    /**
     * ���[�U����ݒ肷��B
     * 
     * @param userName ���[�U��
     */
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
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

    /**
     * Captcha���擾����B
     * 
     * @return Captcha
     */
    @Override
    public String getCaptcha() {
        return this.captcha;
    }

    /**
     * Captcha��ݒ肷��B
     * 
     * @param captcha Captcha
     */
    @Override
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.userId, "userId");
        LoggableUtil.addLog(list, this.userName, "userName");
        LoggableUtil.addLog(list, this.password, "password");
        LoggableUtil.addLog(list, this.captcha, "captcha");

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

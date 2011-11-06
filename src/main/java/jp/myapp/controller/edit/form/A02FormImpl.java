package jp.myapp.controller.edit.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jp.myapp.dao.entity.Users;
import jp.myapp.dao.entity.UsersImpl;
import jp.myapp.util.Loggable;
import jp.myapp.util.LoggableUtil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.opensymphony.xwork2.util.Element;

public class A02FormImpl implements A02Form, Loggable, Serializable {

    private static final long serialVersionUID = -2150353158914657169L;

    private String userId;
    private String[] userSelected;
    private String[] listSelected;
    private List<Users> tUserInfoList = new ArrayList<Users>();

    /**
     * ユーザIDを取得する。
     * 
     * @return ユーザID
     */
    @Override
    public String getUserId() {
        return this.userId;
    }

    /**
     * ユーザIDを設定する。
     * 
     * @param userId ユーザID
     */
    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String[] getUserSelected() {
        return this.userSelected;
    }

    @Override
    public void setUserSelected(String[] userSelected) {
        this.userSelected = userSelected;
    }

    @Override
    public String[] getListSelected() {
        return this.listSelected;
    }

    @Override
    public void setListSelected(String[] listSelected) {
        this.listSelected = listSelected;
    }

    @Override
    @Element(UsersImpl.class)
    public List<Users> getUserInfoList() {
        return this.tUserInfoList;
    }

    @Override
    public void setUserInfoList(List<Users> userInfoList) {
        this.tUserInfoList = userInfoList;
    }

    @Override
    public Collection<String> getLogText() {

        ArrayList<String> list = new ArrayList<String>();

        LoggableUtil.addLog(list, this.userId, "userId");
        LoggableUtil.addLogList(list, this.tUserInfoList, "tUserInfoList");

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

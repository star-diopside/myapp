package jp.myapp.web.controller.edit.form;

import java.util.List;

import jp.myapp.data.entity.management.Users;

public interface A02Form {

    String getUserId();

    void setUserId(String userId);

    String[] getUserSelected();

    void setUserSelected(String[] userSelected);

    String[] getListSelected();

    void setListSelected(String[] listSelected);

    List<Users> getUserInfoList();

    void setUserInfoList(List<Users> userInfoList);

}

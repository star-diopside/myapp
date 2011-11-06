package jp.myapp.controller.edit.form;

import java.util.List;

import jp.myapp.dao.entity.Users;

public interface A02Form {

    String getUserId();

    void setUserId(String userId);

    List<Users> getUserInfoList();

    void setUserInfoList(List<Users> userInfoList);

}

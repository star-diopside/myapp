package jp.myapp.data.dao;

import jp.myapp.data.entity.Users;

public interface UsersDao {

    Users get(String userId);

    Users load(String userId);

    Users loadForUpdate(String userId);

    void update(Users users);

}

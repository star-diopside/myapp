package jp.myapp.data.dao;

import jp.myapp.data.entity.Users;

public interface UsersDao {

    Users get(String userId);

    Users load(String userId);

    void update(Users users);

}

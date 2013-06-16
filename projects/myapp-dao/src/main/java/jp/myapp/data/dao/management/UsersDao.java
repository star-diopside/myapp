package jp.myapp.data.dao.management;

import jp.myapp.data.entity.management.Users;

public interface UsersDao {

    Users get(String userId);

    Users load(String userId);

    Users loadForUpdate(String userId);

    void update(Users users);

}

package jp.myapp.data.mapper.management;

import java.util.List;

import jp.myapp.data.entity.management.Users;
import jp.myapp.data.mapper.base.MapperBase;

public interface UsersMapper extends MapperBase<Users, String> {

    List<Users> selectAll();

}

package jp.myapp.data.mapper;

import java.util.List;

import jp.myapp.data.entity.Users;
import jp.myapp.data.mapper.base.MapperBase;

public interface UsersMapper extends MapperBase<Users, String> {

    List<Users> selectAll();

}

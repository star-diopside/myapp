package jp.myapp.dao.mapper;

import java.util.List;

import jp.myapp.dao.entity.Users;
import jp.myapp.dao.mapper.base.MapperBase;

public interface UsersMapper extends MapperBase<Users, String> {

    List<Users> selectAll();

}

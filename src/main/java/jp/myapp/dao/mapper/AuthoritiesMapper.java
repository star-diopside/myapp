package jp.myapp.dao.mapper;

import jp.myapp.dao.entity.Authorities;
import jp.myapp.dao.entity.AuthoritiesPK;
import jp.myapp.dao.mapper.base.MapperBase;

public interface AuthoritiesMapper extends MapperBase<Authorities, AuthoritiesPK> {

    int deleteByUserId(String userId);

}

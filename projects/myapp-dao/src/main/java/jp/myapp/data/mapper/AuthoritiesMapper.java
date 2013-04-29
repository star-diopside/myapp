package jp.myapp.data.mapper;

import jp.myapp.data.entity.Authorities;
import jp.myapp.data.entity.AuthoritiesPK;
import jp.myapp.data.mapper.base.MapperBase;

public interface AuthoritiesMapper extends MapperBase<Authorities, AuthoritiesPK> {

    int deleteByUserId(String userId);

}

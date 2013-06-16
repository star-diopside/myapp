package jp.myapp.data.mapper.management;

import jp.myapp.data.entity.management.Authorities;
import jp.myapp.data.entity.management.AuthoritiesPK;
import jp.myapp.data.mapper.base.MapperBase;

public interface AuthoritiesMapper extends MapperBase<Authorities, AuthoritiesPK> {

    int deleteByUserId(String userId);

}

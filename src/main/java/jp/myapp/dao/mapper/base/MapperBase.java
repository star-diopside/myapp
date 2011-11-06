package jp.myapp.dao.mapper.base;

import jp.myapp.dao.entity.base.EntityBase;

public interface MapperBase<Entity extends EntityBase<PK>, PK> {

    Entity select(PK pk);

    Entity selectForUpdate(PK pk);

    int insert(Entity entity);

    int update(Entity entity);

    int delete(PK pk);

}

package jp.myapp.data.mapper.base;

import java.io.Serializable;

import jp.myapp.data.entity.base.EntityBase;

public interface MapperBase<Entity extends EntityBase<PK>, PK extends Serializable> {

    Entity select(PK pk);

    Entity selectForUpdate(PK pk);

    int insert(Entity entity);

    int update(Entity entity);

    int delete(PK pk);

}

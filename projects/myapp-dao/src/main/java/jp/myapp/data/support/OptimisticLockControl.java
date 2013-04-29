package jp.myapp.data.support;

import java.io.Serializable;

import jp.myapp.data.entity.base.EntityBase;
import jp.myapp.data.mapper.base.MapperBase;
import jp.myapp.exception.ExclusiveException;

/**
 * 楽観排他ロックを行うためのラッパークラス
 * 
 * @param <Entity> エンティティクラス
 * @param <PK> 主キークラス
 */
public class OptimisticLockControl<Entity extends EntityBase<PK>, PK extends Serializable> {

    private MapperBase<Entity, PK> mapper;

    public OptimisticLockControl(MapperBase<Entity, PK> mapper) {
        this.mapper = mapper;
    }

    public MapperBase<Entity, PK> getMapper() {
        return mapper;
    }

    /**
     * レコードロックを行い、楽観排他チェックを行う。
     * 
     * @param entity エンティティ
     * @return ロックを行ったレコード情報
     * @exception ExclusiveException 楽観排他エラーの場合
     */
    public Entity lock(Entity entity) {
        return this.lock(entity.getPK(), entity.getVersion());
    }

    /**
     * レコードロックを行い、楽観排他チェックを行う。
     * 
     * @param pk 主キー
     * @param version 楽観排他キー
     * @exception ExclusiveException 楽観排他エラーの場合
     */
    public Entity lock(PK pk, Integer version) {

        Entity entity = this.mapper.selectForUpdate(pk);

        if (entity == null || entity.getVersion() == null || !entity.getVersion().equals(version)) {
            throw new ExclusiveException();
        }

        return entity;
    }

    /**
     * 楽観排他チェック後に更新処理を行う。
     * 
     * @param entity エンティティ
     * @return 更新件数
     * @exception ExclusiveException 楽観排他エラーの場合
     */
    public int update(Entity entity) {

        this.lock(entity);

        Integer version = entity.getVersion();

        if (version == null || version.intValue() == Integer.MAX_VALUE) {
            entity.setVersion(0);
        } else {
            entity.setVersion(version + 1);
        }

        return this.mapper.update(entity);
    }

    /**
     * 楽観排他チェック後に削除処理を行う。
     * 
     * @param entity エンティティ
     * @return 削除件数
     * @exception ExclusiveException 楽観排他エラーの場合
     */
    public int delete(Entity entity) {
        this.lock(entity);
        return this.mapper.delete(entity.getPK());
    }
}

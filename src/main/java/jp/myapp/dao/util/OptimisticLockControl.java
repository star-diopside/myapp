package jp.myapp.dao.util;

import jp.myapp.dao.entity.base.EntityBase;
import jp.myapp.dao.mapper.base.MapperBase;
import jp.myapp.exception.ExclusiveException;

/**
 * 楽観排他ロックを行うためのラッパークラス
 * 
 * @param <Entity> エンティティクラス
 * @param <PK> 主キークラス
 */
public class OptimisticLockControl<Entity extends EntityBase<PK>, PK> {

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
     */
    public void lock(Entity entity) {
        this.checkVersion(entity.getPK(), entity.getVersion());
    }

    /**
     * 楽観排他チェック後に更新処理を行う。
     * 
     * @param entity エンティティ
     * @return 更新件数
     */
    public int update(Entity entity) {

        this.checkVersion(entity.getPK(), entity.getVersion());

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
     */
    public int delete(Entity entity) {
        this.checkVersion(entity.getPK(), entity.getVersion());
        return this.mapper.delete(entity.getPK());
    }

    /**
     * 排他キーチェックを行う。
     * 
     * @param pk 主キー
     * @param version 楽観排他キー
     */
    private void checkVersion(PK pk, Integer version) {

        Entity entity = this.mapper.selectForUpdate(pk);

        if (entity == null || entity.getVersion() == null || !entity.getVersion().equals(version)) {
            throw new ExclusiveException();
        }
    }
}

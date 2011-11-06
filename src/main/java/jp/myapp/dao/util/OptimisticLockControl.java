package jp.myapp.dao.util;

import jp.myapp.dao.entity.base.EntityBase;
import jp.myapp.dao.mapper.base.MapperBase;
import jp.myapp.exception.ExclusiveException;

/**
 * �y�ϔr�����b�N���s�����߂̃��b�p�[�N���X
 * 
 * @param <Entity> �G���e�B�e�B�N���X
 * @param <PK> ��L�[�N���X
 */
public class OptimisticLockControl<Entity extends EntityBase<PK>, PK> {

    private MapperBase<Entity, PK> mapper;

    public OptimisticLockControl(MapperBase<Entity, PK> mapper) {
        this.mapper = mapper;
    }

    public MapperBase<Entity, PK> getMapper() {
        return mapper;
    }

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

    public int delete(Entity entity) {
        this.checkVersion(entity.getPK(), entity.getVersion());
        return this.mapper.delete(entity.getPK());
    }

    /**
     * �r���L�[�`�F�b�N���s���B
     * 
     * @param pk ��L�[
     * @param version �y�ϔr���L�[
     */
    private void checkVersion(PK pk, Integer version) {

        Entity entity = this.mapper.selectForUpdate(pk);

        if (entity.getVersion() == null || !entity.getVersion().equals(version)) {
            throw new ExclusiveException();
        }
    }
}
